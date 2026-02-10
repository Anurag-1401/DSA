class Solution {
    public int maxChocolates(int[][] g) {
        int r = g.length;
        int c = g[0].length;

        int[][][] dp = new int[r][c][c];

        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if (j1 == j2)
                    dp[r - 1][j1][j2] = g[r - 1][j1];
                else
                    dp[r - 1][j1][j2] = g[r - 1][j1] + g[r - 1][j2];
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {

                    int max = Integer.MIN_VALUE;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {

                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < c &&
                                nj2 >= 0 && nj2 < c) {

                                int value;
                                if (j1 == j2)
                                    value = g[i][j1];
                                else
                                    value = g[i][j1] + g[i][j2];

                                value += dp[i + 1][nj1][nj2];
                                max = Math.max(max, value);
                            }
                        }
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][c - 1];
    }
}
