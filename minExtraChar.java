class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];

        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = 1 + dp[i + 1];

            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);

                if (dict.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[0];
    }
}
