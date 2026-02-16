class Solution {

    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCheck(i, adj, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean bfsCheck(int start, List<Integer>[] adj, boolean[] visited) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start, -1});
        visited[start] = true;

        while (!q.isEmpty()) {

            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neigh : adj[node]) {

                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.offer(new int[]{neigh, node});
                }

                else if (neigh != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}
