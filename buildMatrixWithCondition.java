class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<Integer> rowOrder = topoSort(k, rowConditions);
        List<Integer> colOrder = topoSort(k, colConditions);

        if (rowOrder.size() == 0 || colOrder.size() == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];

        Map<Integer, Integer> rowPos = new HashMap<>();
        Map<Integer, Integer> colPos = new HashMap<>();

        for (int i = 0; i < k; i++) {
            rowPos.put(rowOrder.get(i), i);
            colPos.put(colOrder.get(i), i);
        }

        for (int num = 1; num <= k; num++) {
            int r = rowPos.get(num);
            int c = colPos.get(num);
            matrix[r][c] = num;
        }

        return matrix;
    }

    private List<Integer> topoSort(int k, int[][] conditions) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] cond : conditions) {
            int u = cond[0];
            int v = cond[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);

            for (int nei : graph.get(curr)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        if (order.size() != k) return new ArrayList<>();

        return order;
    }
}
