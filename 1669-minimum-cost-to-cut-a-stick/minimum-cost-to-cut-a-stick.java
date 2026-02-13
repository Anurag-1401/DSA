import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        int[] allCuts = new int[m + 2];
        allCuts[0] = 0;
        allCuts[m + 1] = n;

        for (int i = 0; i < m; i++) {
            allCuts[i + 1] = cuts[i];
        }

        Arrays.sort(allCuts);

        int[][] dp = new int[m + 2][m + 2];

        // Interval length
        for (int len = 2; len < m + 2; len++) {

            for (int i = 0; i + len < m + 2; i++) {

                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k][j]
                             + allCuts[j] - allCuts[i];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}
