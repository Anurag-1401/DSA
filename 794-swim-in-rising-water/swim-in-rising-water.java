class Solution {
    private static int n;
    public int swimInWater(int[][] grid) {
        this.n = grid.length;
        int left = grid[0][0];
        int right = n*n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[n][n];
            if(dfs(0,0,grid,mid,visited)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
   
    }

    private boolean dfs(int i, int j, int[][] grid, int time, boolean[][] visited) {
        if (i<0 || i>=grid.length || j<0|| j>=grid[0].length||grid[i][j]>time||visited[i][j]){
            return false;
        }
        visited[i][j] = true;

        if (i == grid.length - 1 && j == grid[0].length - 1) return true;
        if (dfs(i + 1, j, grid, time,visited) ||
        dfs(i, j+1, grid, time,visited) ||
        dfs(i-1, j, grid, time,visited) ||
        dfs(i, j-1, grid, time,visited)
        ) return true;

        return false; 
    }
}