class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {


        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        int[][] dp = new int[a.length+1][b.length+1];
    

        for (int i = 1; i<dp.length; i++){
            for (int j = 1; j<dp[0].length; j++){
                if (a[i-1]==b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }


            }
        }

        
        int l =  text1.length()+text2.length()-dp[a.length][b.length];
        int m = text1.length(), n = text2.length();
        char[] chr = new char[l];
        while (m>0 && n>0){
            char cur;
            if (text1.charAt(m-1) == text2.charAt(n-1)){
                cur = text1.charAt(m-1);
                m--;
                n--;
            } else if (dp[m-1][n] > dp[m][n-1]){
                cur = text1.charAt(m-1);
                m--;
                

            } else {
                cur = text2.charAt(n-1);
                n--;
            }

            chr[--l] = cur;


        }
        while (m-->0){
            chr[--l]=text1.charAt(m);
            //m--;
        }
        while (n-->0){
            chr[--l]=text2.charAt(n);
            //m--;
        }

        return new String(chr);

        
    }

}