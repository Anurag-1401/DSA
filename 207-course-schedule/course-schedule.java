class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        int[] head = new int[numCourses];
        Arrays.fill(head, -1);
        
        int m = prerequisites.length;
        int[] to = new int[m];
        int[] next = new int[m];

        for (int i = 0; i < m; i++) {
            int u = prerequisites[i][0]; 
            int v = prerequisites[i][1];
            
            to[i] = u;
            next[i] = head[v];
            head[v] = i;
            
            indegree[u]++;
        }

        int[] queue = new int[numCourses];
        int left = 0;
        int right = 0;

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue[right++] = i;
            }
        }

        int processedCount = 0;
        while (left < right) {
            int node = queue[left++];
            processedCount++;

            for (int i = head[node]; i != -1; i = next[i]) {
                int neighbor = to[i];
                if (--indegree[neighbor] == 0) {
                    queue[right++] = neighbor;
                }
            }
        }

        return processedCount == numCourses;
    }
}