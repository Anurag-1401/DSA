class Solution {
    public void setZeroes(int[][] matrix) {
         int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int row : zeroRows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }

        for (int col : zeroCols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }


    }
}