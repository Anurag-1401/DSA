class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        if (arr[0] <= target) {
            dp[arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int t = target; t >= arr[i]; t--) {
                dp[t] = dp[t] || dp[t - arr[i]];
            }
        }

        return dp[target];
    }
}
