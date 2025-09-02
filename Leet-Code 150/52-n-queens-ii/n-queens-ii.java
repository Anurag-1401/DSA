class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2*n - 1];
        boolean[] anti = new boolean[2*n - 1];
        
        backtrack(0, n, count, cols, diag, anti);
        return count[0];
    }

    private void backtrack(int row, int n, int[] count, boolean[] cols, boolean[] diag, boolean[] anti) {
        if (row == n) {
            count[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || diag[row + col] || anti[row - col + n - 1]) continue;
            cols[col] = diag[row + col] = anti[row - col + n - 1] = true;
            backtrack(row + 1, n, count, cols, diag, anti);
            cols[col] = diag[row + col] = anti[row - col + n - 1] = false;
        }
    }
}
