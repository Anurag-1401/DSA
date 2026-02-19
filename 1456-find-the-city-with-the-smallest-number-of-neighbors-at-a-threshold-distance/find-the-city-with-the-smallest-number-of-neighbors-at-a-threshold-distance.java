class Solution {
    public int findTheCity(int n, int[][] edges, int max) {
        int[][] dist = new int[n][n];
        for(int[] x : dist) Arrays.fill(x, 1000000);
        for(int i = 0; i < n; i++) dist[i][i] = 0;

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            dist[a][b] = dist[b][a] = edge[2];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(dist[j][i] + dist[i][k] < dist[j][k]) dist[j][k] = dist[k][j] = dist[j][i] + dist[i][k];
                }
            }
        }
        int min = n, ans = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(dist[i][j] <= max) count++;
            }
            if(count <= min) {
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}