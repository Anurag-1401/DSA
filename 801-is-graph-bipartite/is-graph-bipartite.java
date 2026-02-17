class Solution {

    public boolean solve(int node, int parent, boolean flag,
                         int[][] graph, int[] color, boolean[] visited) {

        color[node] = flag ? 1 : 0;
        visited[node] = true;

        for (int adj : graph[node]) {

            if (!visited[adj]) {
                if (!solve(adj, node, !flag, graph, color, visited)) {
                    return false;
                }
            } 
            else if (color[adj] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        boolean[] visited = new boolean[n];

        // initialize color with -1 (optional but good practice)
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!solve(i, i, false, graph, color, visited)) {
                    return false;
                }
            }
        }

        return true;
    }
}