class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        // 0 = not visited
        // 1 = visiting
        // 2 = visited and safe
        // 3 = visited but not safe

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 2 || (visited[i] == 0 && !findCycle(graph, visited, i))) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean findCycle(int[][] graph, int[] visited, int i) {
        visited[i] = 1;

        for (int nei : graph[i]) {
            if (visited[nei] == 2) {
                continue;
            } else if (visited[nei] == 3 || visited[nei] == 1) {
                visited[i] = 3;
                return true;
            } else if (findCycle(graph, visited, nei)) {
                visited[i] = 3;
                return true;
            }
        }

        visited[i] = 2;
        return false;
    }
}