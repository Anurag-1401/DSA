class Solution {
    public int minCut(String s) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        // Precompute palindrome table
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (len <= 2)
                        pal[i][j] = true;
                    else
                        pal[i][j] = pal[i + 1][j - 1];
                }
            }
        }

        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            int minCuts = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {

                if (pal[i][j]) {

                    if (j == n - 1)
                        minCuts = 0; // No cut needed
                    else
                        minCuts = Math.min(minCuts, 1 + dp[j + 1]);
                }
            }

            dp[i] = minCuts;
        }

        return dp[0];
    }
}
