import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            adj.get(prereq).add(course);  // prereq → course
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add indegree 0 nodes
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int processed = 0;

        // Kahn's BFS
        while (!q.isEmpty()) {

            int node = q.poll();
            processed++;

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        // If all nodes processed → no cycle
        return processed == numCourses;
    }
}
