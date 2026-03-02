class Solution {
    public int minDistance(String text1, String text2) {

        char[] A = text1.toCharArray();
        char[] B = text2.toCharArray();

        int n = A.length;
        int m = B.length;

        int[] grid = new int[m + 1];

        int diag, temp;

        for (int i = 1; i <= n; i++) {

            diag = 0;

            for (int j = 1; j <= m; j++) {

                temp = grid[j];

                if (A[i - 1] == B[j - 1]) {
                    grid[j] = diag + 1;
                } else {
                    grid[j] = Math.max(grid[j], grid[j - 1]);
                }

                diag = temp;
            }
        }

        int lcs = grid[m];

        return n + m - 2 * lcs;
    }
}
