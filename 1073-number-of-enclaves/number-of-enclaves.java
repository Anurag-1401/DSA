class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        for(int i=0;i<n;i++){
            dfs(grid,0,i);
            dfs(grid,m-1,i);
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c+=grid[i][j];
            }
        }
        return c;
    }
    private void dfs(int g[][],int i,int j){
        if(i<0 || j<0 || i>=g.length || j>=g[0].length || g[i][j]==0)
            return ;
        g[i][j]=0;
        dfs(g,i+1,j);
        dfs(g,i-1,j);
        dfs(g,i,j+1);
        dfs(g,i,j-1);
    } 

}