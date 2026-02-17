class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] prereq = new List[numCourses];
        for (int i=0; i<numCourses; i++) {
            prereq[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            prereq[prerequisite[0]].add(prerequisite[1]);
        }
        int[] res = new int[numCourses];
        int[] run_idx = new int[1];

        int[] visited = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (visited[i] != 0) {
                continue;
            }
            if (!dfs(i, visited, prereq, res, run_idx)) {
                return new int[0];
            }
        }

        for (int i=0; i<numCourses; i++) {
            if (visited[i] != 2) {
                res[run_idx[0]++] = i;
            }
        }
        
        return res;
    }

    // Normal DFS
    public boolean dfs(int root, int[] visited, List<Integer>[] prereq, int[] res, int[] run_idx) {
        visited[root] = 1;


        List<Integer> neighs = prereq[root];

        for (int neigh : neighs) {
            if (visited[neigh] == 1) {
                return false;
            }
            if (visited[neigh] == 2) {
                continue;
            }
            boolean neigh_dfs = dfs(neigh, visited, prereq, res, run_idx);
            if (!neigh_dfs) {
                return false;
            }
        }

        visited[root] = 2;
        res[run_idx[0]++] = root;
        return true;
    }
}