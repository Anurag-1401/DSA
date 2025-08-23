class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        int[] indeg = new int[numCourses];

        for (int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);   
            indeg[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.offer(i);

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : g.get(u)) {
                if (--indeg[v] == 0) q.offer(v);
            }
        }
        return idx == numCourses ? order : new int[0];
    }
}
