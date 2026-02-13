class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n + 1];

        // Build from end → start
        for (int i = n - 1; i >= 0; i--) {

            int maxVal = 0;
            int best = 0;

            for (int j = i; j < n && j < i + k; j++) {

                maxVal = Math.max(maxVal, arr[j]);

                int len = j - i + 1;

                int sum = maxVal * len + dp[j + 1];

                best = Math.max(best, sum);
            }

            dp[i] = best;
        }

        return dp[0];
    }
}
