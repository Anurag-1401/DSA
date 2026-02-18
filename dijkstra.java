class Solution
{
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[S] = 0;
        pq.offer(new int[]{0, S});

        while (!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if (d > dist[node]) continue;

            for (ArrayList<Integer> edge : adj.get(node))
            {
                int neigh = edge.get(0);
                int weight = edge.get(1);

                if (dist[node] + weight < dist[neigh])
                {
                    dist[neigh] = dist[node] + weight;
                    pq.offer(new int[]{dist[neigh], neigh});
                }
            }
        }

        return dist;
    }
}
