class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Total path length is m + n - 1. A valid parentheses string must have an even length.
        if ((m + n - 1) % 2 != 0) return false;
        
        // Start grid must be '(' and end grid must be ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        // Max possible open bracket count at any point is (m + n - 1) / 2 + 1
        memo = new Boolean[m][n][(m + n) / 2 + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int open) {
        // Track net open bracket balance
        open += (grid[r][c] == '(' ? 1 : -1);

        // If balance drops below 0 or exceeds half length, path is invalid
        if (open < 0 || open > (m + n) / 2) return false;

        // Reached destination: check if all brackets are balanced
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }

        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }

        boolean found = false;

        // Move Right
        if (c + 1 < n) {
            found = dfs(grid, r, c + 1, open);
        }

        // Move Down
        if (!found && r + 1 < m) {
            found = dfs(grid, r + 1, c, open);
        }

        return memo[r][c][open] = found;
    }
}