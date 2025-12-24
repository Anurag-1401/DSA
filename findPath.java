class Solution {
    public List<String> findPath(int[][] grid) {
        List<String> res = new ArrayList<>();
        int n = grid.length;

        if(grid[0][0] == 0) return res;

        boolean[][] visited = new boolean[n][n];

        find(0,0,"",res,visited,grid,n);
        return res;
    }

    private void find(int r,int c,String path,List<String> res,boolean[][] visited,int[][] grid,int n){
        if(r==n-1&&c==n-1){
            res.add(path);
            return;
        }

        visited[r][c] = true;

        if(r+1<n && !visited[r+1][c] && grid[r+1][c] == 1){
            find(r+1,c,path+"D",res,visited,grid,n);
        }

        if(c-1>=0 && !visited[r][c-1] && grid[r][c-1] == 1){
            find(r,c-1,path+"L",res,visited,grid,n);
        }

        if(c+1<n && !visited[r][c+1] && grid[r][c+1] == 1){
            find(r,c+1,path+"R",res,visited,grid,n);
        }

        if(r-1>=0 && !visited[r-1][c] && grid[r-1][c] == 1){
            find(r-1,c,path+"U",res,visited,grid,n);
        }

        visited[r][c] = false;
    }
}
