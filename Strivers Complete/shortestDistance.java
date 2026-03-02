class Solution {
    public void shortestDistance(int[][] matrix) {

        int V = matrix.length;
        int INF = (int)1e9;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {

                if (matrix[i][j] == -1)
                    matrix[i][j] = INF;

                if (i == j)
                    matrix[i][j] = 0;
            }
        }

        for (int via = 0; via < V; via++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    if (matrix[i][via] + matrix[via][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][via] + matrix[via][j];
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {

                if (matrix[i][j] == INF)
                    matrix[i][j] = -1;
            }
        }
    }
}
