class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] = Math.min(dp[x], 1 + dp[x - coin]);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
