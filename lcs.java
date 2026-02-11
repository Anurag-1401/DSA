class Solution {
    public int lcs( String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1] = str1.charAt(i) == str2.charAt(j) ? 1+dp[i][j] 
                : Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[m][n];
    }
}

