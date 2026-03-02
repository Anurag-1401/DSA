class Solution {
    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int provinces = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int city, int[][] graph, boolean[] visited) {
        visited[city] = true;

        for (int neigh = 0; neigh < graph.length; neigh++) {
            if (graph[city][neigh] == 1 && !visited[neigh]) {
                dfs(neigh, graph, visited);
            }
        }
    }
}