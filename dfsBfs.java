class Solution {
   public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        dfs(0, adj, visited, result);

        return result;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited, result);
            }
        }
    }
    
        public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }

        return result;
    }
}

