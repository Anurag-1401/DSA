class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] reach = new boolean[n][n];

        for (int[] p : prerequisites) {
            reach[p[0]][p[1]] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();

        for (int[] q : queries) {
            res.add(reach[q[0]][q[1]]);
        }

        return res;
    }
}
