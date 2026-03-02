class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> e: edges){
            int u = e.get(0);
            int v = e.get(1);
        
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int comp = 0;

        for(int i=0;i<V;i++){
            if(!visited[i]) {
                comp++;
                dfs(i,adj,visited);
            }
        }

        return comp;
    }

    private void dfs(int i,List<List<Integer>> adj,boolean[] visited){
        visited[i] = true;

        for(int neig : adj.get(i)){
            if(!visited[neig]) dfs(neig,adj,visited);
        }
    }
}
