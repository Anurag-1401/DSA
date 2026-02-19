class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> a[0] - b[0]);

        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (time > dist[node]) continue;

            for (int[] edge : adj.get(node)) {

                int neigh = edge[0];
                int weight = edge[1];

                if (dist[node] + weight < dist[neigh]) {

                    dist[neigh] = dist[node] + weight;
                    pq.offer(new int[]{dist[neigh], neigh});
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int)1e9)
                return -1;

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
