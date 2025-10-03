class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        Queue<Integer> q = new LinkedList<>();
        int node = 0;

        for(int i=0;i<n;i++){
            if(color[i] != -1) continue;
            q.add(i);
            color[i] = 0;

            while(!q.isEmpty()){
                node = q.poll();
                
                for(int neigh : graph[node]){
                    if(color[neigh] == -1){
                        color[neigh] = 1 - color[node];
                        q.add(neigh);
                    } else if(color[neigh] == color[node]) return false;
                }
            }
        }
        return true;
    }
}