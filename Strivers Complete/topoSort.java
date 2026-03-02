class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {

        int[] indegree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] topo = new int[V];
        int idx = 0;

        while (!q.isEmpty()) {

            int node = q.poll();
            topo[idx++] = node;

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        return topo;
    }
}
