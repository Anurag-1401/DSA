class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]); 
            indegree[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0) q.offer(i);
        
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int nei : graph.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }
        
        return count == numCourses;
    }
}
