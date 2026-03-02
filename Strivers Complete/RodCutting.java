class Solution {
    public int RodCutting(int price[], int n) {
        int[] dp = new int[n + 1];

        for (int len = 1; len <= n; len++) {
            for (int cut = 0; cut < len; cut++) {
                dp[len] = Math.max(dp[len],
                                   price[cut] + dp[len - (cut + 1)]);
            }
        }

        return dp[n];
    }
}
