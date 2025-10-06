class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length,cols = grid[0].length,fresh=0,mins=0,size=0,nr=0,nc=0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int[] cell;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] == 2) q.add(new int[]{r,c});
                if(grid[r][c] == 1) fresh++;
            }
        }
        while(!q.isEmpty() && fresh > 0){
            size = q.size();
            
            for(int i =0 ;i<size;i++){
                cell = q.poll();
                
                for(int[] d:dirs){
                    nr = cell[0] + d[0];
                    nc = cell[1] + d[1];
                    if(nr<0 || nc<0 || nr>=rows || nc>=cols || grid[nr][nc]!=1) continue;
                    grid[nr][nc] = 2;
                    fresh--;
                    q.add(new int[]{nr,nc});
                }
            }
            mins++;
        }
        return fresh == 0 ? mins : -1;
    }
}