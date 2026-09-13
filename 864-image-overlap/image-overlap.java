class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int rowOffset = -n + 1; rowOffset < n; rowOffset++) {
            for (int colOffset = -n + 1; colOffset < n; colOffset++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, rowOffset, colOffset, n));
            }
        }

        return maxOverlap;
    }

    private int countOverlap(int[][] img1, int[][] img2, int rowOffset, int colOffset, int n) {
        int overlap = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r + rowOffset < 0 || r + rowOffset >= n || c + colOffset < 0 || c + colOffset >= n) {
                    continue;
                }
                if (img1[r][c] == 1 && img2[r + rowOffset][c + colOffset] == 1) {
                    overlap++;
                }
            }
        }

        return overlap;
    }
}