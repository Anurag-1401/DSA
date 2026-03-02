class Solution {
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        int mod = 1000000007;

        long[] dp = new long[K + 1];

        dp[0] = 1;

        for (int num : arr) {
            long[] next = dp.clone();

            for (int t = num; t <= K; t++) {
                next[t] = (next[t] + dp[t - num]) % mod;
            }

            dp = next;
        }

        return (int) dp[K];
    }
}
