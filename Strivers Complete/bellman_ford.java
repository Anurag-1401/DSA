class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {

        int INF = (int)1e9;

        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        dist[S] = 0;

        for (int i = 1; i <= V - 1; i++) {

            for (ArrayList<Integer> edge : edges) {

                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);

                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (ArrayList<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            if (dist[u] != INF && dist[u] + w < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}
