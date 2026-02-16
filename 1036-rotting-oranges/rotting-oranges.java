class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length  ==0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] time = new int[rows][cols];

        for(int i=0;i<rows;i++)
            Arrays.fill(time[i],Integer.MAX_VALUE);
       

        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
            if(grid[i][j] == 2)
                dfs(grid,time,i,j,0);

        int timerequired = 0;
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(grid[i][j] == 1){
            if(time[i][j]==Integer.MAX_VALUE)return -1;
            timerequired = Math.max(timerequired,time[i][j]);
        }   
        return timerequired;
    }

    private void dfs(int[][]grid,int[][] time,int i,int j,int currenttime){

        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0 ||
             currenttime >= time[i][j]) return;


        time[i][j] =currenttime;
        dfs(grid,time,i-1,j,currenttime+1);
        dfs(grid,time,i+1,j,currenttime+1);
        dfs(grid,time,i,j-1,currenttime+1);
        dfs(grid,time,i,j+1,currenttime+1);
    }
}