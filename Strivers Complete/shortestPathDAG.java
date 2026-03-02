class Solution {

    public int[] shortestPath(int N, int M, int[][] edges) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new int[]{v, w});
        }

        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i])
                topoDFS(i, adj, visited, stack);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e9);

        dist[0] = 0;

        while (!stack.isEmpty()) {

            int node = stack.pop();

            if (dist[node] != (int)1e9) {

                for (int[] edge : adj.get(node)) {

                    int neigh = edge[0];
                    int weight = edge[1];

                    if (dist[node] + weight < dist[neigh]) {
                        dist[neigh] = dist[node] + weight;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == (int)1e9)
                dist[i] = -1;
        }

        return dist;
    }

    private void topoDFS(int node, List<List<int[]>> adj,
                         boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for (int[] edge : adj.get(node)) {
            int neigh = edge[0];

            if (!visited[neigh])
                topoDFS(neigh, adj, visited, stack);
        }

        stack.push(node);
    }
}
