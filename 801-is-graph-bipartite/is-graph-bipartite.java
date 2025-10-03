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


// class Solution {

//     public boolean dfs(int src, int par, int[] color, int[][] graph, int colorToFill){

//         color[src] = colorToFill;

//         for(int v : graph[src]){

//             if(color[v] == -1){
//                boolean ans = dfs(v, src, color, graph, 1 - color[src]);
//                if(ans == false){
//                 return false;
//                }
//             }else if(color[v] == colorToFill){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean isBipartite(int[][] graph) {
        
//         int n = graph.length;
//         int[] color = new int[n];
//         Arrays.fill(color, -1);

//         for(int s = 0 ; s < n ; s++){

//             if(color[s] == -1){

//                 boolean ans = dfs(s, -1, color, graph, 1);

//                 if(ans == false){
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }