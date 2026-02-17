class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            adj.get(prereq).add(course); // prereq → course
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        // Kahn's BFS
        while (!q.isEmpty()) {

            int node = q.poll();
            order[idx++] = node;

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        // Cycle check
        if (idx != numCourses)
            return new int[0];

        return order;
    }
}
