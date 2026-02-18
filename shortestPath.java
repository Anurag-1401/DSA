class Solution {
    public int[] shortestPath(int[][] edges, int N, int M) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        dist[0] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neigh : adj.get(node)) {

                if (dist[neigh] == -1) {
                    dist[neigh] = dist[node] + 1;
                    q.offer(neigh);
                }
            }
        }

        return dist;
    }
}
