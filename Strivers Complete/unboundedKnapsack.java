class Solution {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = wt[i]; w <= W; w++) {
                dp[w] = Math.max(dp[w],
                                 val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }
}
