class Solution {
    public boolean isBipartite(int[][] graph) {

        int V = graph.length;
        int[] color = new int[V];

        Arrays.fill(color, -1); // -1 = uncolored

        for (int start = 0; start < V; start++) {

            if (color[start] != -1) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            color[start] = 0;

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int neigh : graph[node]) {

                    // Not colored → assign opposite color
                    if (color[neigh] == -1) {
                        color[neigh] = 1 - color[node];
                        q.offer(neigh);
                    }

                    // Same color → not bipartite
                    else if (color[neigh] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
