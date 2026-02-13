class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        System.arraycopy(cuts, 0, arr, 1, m);
        Arrays.sort(arr);

        int[][] dp = new int[m + 2][m + 2];
        int[][] opt = new int[m + 2][m + 2];

        for (int len = 2; len <= m + 1; len++) {
            for (int l = 0; l + len <= m + 1; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;

                int start = (len == 2) ? l + 1 : opt[l][r - 1];
                int end = (len == 2) ? r - 1 : opt[l + 1][r];

                for (int k = start; k <= end; k++) {
                    int cost = dp[l][k] + dp[k][r] + arr[r] - arr[l];
                    if (cost < dp[l][r]) {
                        dp[l][r] = cost;
                        opt[l][r] = k;
                    }
                }
            }
        }

        return dp[0][m + 1];            
    }
}