class Solution {
    boolean pos=true;
    
    public void traverse(List<Integer>[] adj,int start,int[] visited){
        if(visited[start]==0){
            visited[start]=1;
            for(int i=0;i<adj[start].size();i++)
            {
                traverse(adj,adj[start].get(i),visited);
            }
            visited[start]=2;
        } else {
            if(visited[start]==1){
                pos=false;
            }
            return;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new ArrayList[numCourses];

        int[] visited=new int[numCourses];

        for(int i=0;i<numCourses;i++) adj[i]=new ArrayList<>();

        for(int i=0;i<prerequisites.length;i++) adj[prerequisites[i][1]].add(prerequisites[i][0]);
        for(int i=0;i<visited.length;i++){
            pos=true;
            traverse(adj,i,visited);
                if(pos==false) return false;
        }
        
        return pos;
    }
}