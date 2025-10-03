class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count=0,curr=0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] ind = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());

        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
            ind[p[0]]++;
        }

        for(int i=0;i<numCourses;i++) if(ind[i] == 0) q.offer(i);

        while(!q.isEmpty()){
            curr = q.poll();
            count++;
            for(int neigh : graph.get(curr)){
                ind[neigh]--;
                if(ind[neigh] == 0) q.offer(neigh);
            }
        }
        return count == numCourses;
    }
}