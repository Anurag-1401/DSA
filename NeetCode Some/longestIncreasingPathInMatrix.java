class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{matrix[i][j], i, j});
            }
        }

        Collections.sort(cells, (a, b) -> b[0] - a[0]);
        
        int[][] dp = new int[m][n];
        int maxPath = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int[] cell : cells) {
            int r = cell[1], c = cell[2];
            int currentMax = 1;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                    currentMax = Math.max(currentMax, 1 + dp[nr][nc]);
                }
            }
            dp[r][c] = currentMax;
            maxPath = Math.max(maxPath, dp[r][c]);
        }
        
        return maxPath;
    }
}
