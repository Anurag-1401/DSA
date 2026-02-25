class Solution {

    int timer = 0;
    List<List<Integer>> adj;
    int[] tin, low;
    boolean[] visited;
    List<List<Integer>> bridges = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> e : connections) {
            int u = e.get(0);
            int v = e.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        tin = new int[n];
        low = new int[n];
        visited = new boolean[n];

        dfs(0, -1);

        return bridges;
    }

    private void dfs(int node, int parent) {

        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int neigh : adj.get(node)) {

            if (neigh == parent) continue;

            if (!visited[neigh]) {

                dfs(neigh, node);

                low[node] = Math.min(low[node], low[neigh]);

                // Bridge condition ⭐
                if (low[neigh] > tin[node]) {
                    bridges.add(Arrays.asList(node, neigh));
                }
            }
            else {
                // Back edge
                low[node] = Math.min(low[node], tin[neigh]);
            }
        }
    }
}