class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(grid[i][j]==1){
                    return dfs(grid, visited, i, j);
                } 
        return 0;
    }
    public int dfs(int[][] grid, boolean[][] visited, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ||grid[i][j]==0) return 1; //Exited
        else{
            if(visited[i][j]) return 0;
            else{
                visited[i][j] = true;
                return dfs(grid, visited, i+1, j)+
                dfs(grid, visited, i, j+1)+
                dfs(grid, visited, i-1, j)+
                dfs(grid, visited, i, j-1);
            }
        }
    }
}
