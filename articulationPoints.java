class Solution {

    int timer = 0;
    int[] tin, low;
    boolean[] visited;
    boolean[] isArticulation;

    public ArrayList<Integer> articulationPoints(int n,
            ArrayList<ArrayList<Integer>> adj) {

        tin = new int[n];
        low = new int[n];
        visited = new boolean[n];
        isArticulation = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isArticulation[i])
                res.add(i);
        }

        if (res.size() == 0) {
            res.add(-1);
        }

        return res;
    }

    private void dfs(int node, int parent,
                     ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;
        tin[node] = low[node] = timer++;

        int childCount = 0;

        for (int neigh : adj.get(node)) {

            if (neigh == parent) continue;

            if (!visited[neigh]) {

                dfs(neigh, node, adj);

                low[node] = Math.min(low[node], low[neigh]);

                if (low[neigh] >= tin[node] && parent != -1) {
                    isArticulation[node] = true;
                }

                childCount++;
            }
            else {
                low[node] = Math.min(low[node], tin[neigh]);
            }
        }

        if (parent == -1 && childCount > 1) {
            isArticulation[node] = true;
        }
    }
}
