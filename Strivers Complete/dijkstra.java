class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[S] = 0;
        pq.add(new int[]{0, S});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int node = current[1];

            if (d > dist[node]) continue;

            for (int[] neighborEdge : adj.get(node)) {
                int neighbor = neighborEdge[0];
                int weight = neighborEdge[1];

                if (dist[node] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[node] + weight;
                    pq.add(new int[]{dist[neighbor], neighbor});
                }
            }
        }

        return dist;
    }
}
