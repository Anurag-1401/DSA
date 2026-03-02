class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int s1 = (sum + target) / 2;
        int mod = 1000000007;

        long[] dp = new long[s1 + 1];
        dp[0] = 1;

        for (int num : nums) {
            long[] next = dp.clone();

            for (int t = num; t <= s1; t++) {
                next[t] = (next[t] + dp[t - num]) % mod;
            }

            dp = next;
        }

        return (int) dp[s1];
    }
}
