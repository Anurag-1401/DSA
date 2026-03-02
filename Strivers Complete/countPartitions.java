class Solution {
    public int countPartitions(int n, int diff, int[] arr) {
        int mod = 1000000007;
        
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum < diff || (sum + diff) % 2 != 0) {
            return 0;
        }

        int target = (sum + diff) / 2;

        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int num : arr) {
            long[] next = dp.clone();

            for (int t = num; t <= target; t++) {
                next[t] = (next[t] + dp[t - num]) % mod;
            }

            dp = next;
        }

        return (int) dp[target];
    }
}
