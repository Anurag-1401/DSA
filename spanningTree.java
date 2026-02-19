class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        boolean[] visited = new boolean[V];

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0});

        int mstWeight = 0;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int weight = curr[0];
            int node = curr[1];

            if (visited[node]) continue;

            visited[node] = true;
            mstWeight += weight;

            for (List<Integer> edge : adj.get(node)) {

                int neigh = edge.get(0);
                int w = edge.get(1);

                if (!visited[neigh]) {
                    pq.offer(new int[]{w, neigh});
                }
            }
        }

        return mstWeight;
    }
}
