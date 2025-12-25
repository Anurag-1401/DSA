class Solution {
    boolean graphColoring(int[][] edges, int m, int n) {
        int[][] adj =new int[n][n];

        for(int[] e:edges){
            adj[e[1]][e[0]] = 1;
            adj[e[0]][e[1]] = 1;
        } 

        int[] colors = new int[n];

        return solve(0,adj,colors,m,n);
    }

    private boolean solve(int i,int[][] adj,int[] colors,int m,int n){
        if(i==n) return true;

        for(int j=1;j<=m;j++){
            if(isSafe(i,adj,colors,j,n)) {
                colors[i] = j;
                if(solve(i+1,adj,colors,m,n)) return true;
                colors[i] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int i,int[][] adj,int[] colors,int m,int n){
        for(int j=0;j<n;j++){
            if(adj[i][j] == 1 && colors[j] == m) return false;
        }
        return true;
    }
}
