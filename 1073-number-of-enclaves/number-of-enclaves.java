class Solution {
    public int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Remove boundary-connected land
        for (int r = 0; r < rows; r++) {
            dfs(grid, r, 0);
            dfs(grid, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            dfs(grid, 0, c);
            dfs(grid, rows - 1, c);
        }

        // Step 2: Count remaining land
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 1)
                    count++;
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] == 0)
            return;

        grid[r][c] = 0;  // remove land

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
