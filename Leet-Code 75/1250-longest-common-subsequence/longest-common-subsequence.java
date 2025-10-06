// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length(), n = text2.length();
//         int[][] dp = new int[m+1][n+1];

//         for(int i = 0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 dp[i+1][j+1] = text1.charAt(i) == text2.charAt(j) ? 1+dp[i][j] 
//                 : Math.max(dp[i][j+1],dp[i+1][j]);
//             }
//         }
//         return dp[m][n];
//     }
// }


    
class Solution {
        static {
                for(int i = 0; i< 500; i++) {
                            longestCommonSubsequence("","");
                                    }
                                        }
                                            public static int longestCommonSubsequence(String text1, String text2) {
                                                    if(text1.equals(text2))return text1.length();
                                                            int m = text1.length();
                                                                    int n = text2.length();

                                                                            char[] s = text1.toCharArray();
                                                                                    char[] t = text2.toCharArray();

                                                                                            int[][] dp = new int[m+1][n+1];

                                                                                                    for(int i = m-1; i>=0 ; i--) {
                                                                                                                for(int j = n-1 ; j>= 0; j--) {
                                                                                                                                if(s[i] == t[j]) 
                                                                                                                                                    dp[i][j] = dp[i+1][j+1] + 1;
                                                                                                                                                                    else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                                                                                                                                                                                }
                                                                                                                                                                                        }

                                                                                                                                                                                                return dp[0][0];
                                                                                                                                                                                                    }
                                                                                                                                                                                                    }