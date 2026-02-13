class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                int common = arr[i - 1] * arr[j + 1];
                int max = 0;
                for (int k = i; k <= j; k++) {
                    int current = common * arr[k] + dp[i][k - 1] + dp[k + 1][j];
                    if (current > max) {
                        max = current;
                    }
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}