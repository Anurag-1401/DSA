class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int maxDistance = m+n;

        int left = maxDistance, top = maxDistance;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;

                left = maxDistance;
                top = maxDistance;

                if (i-1 >= 0) left = mat[i-1][j];
                if (j-1 >= 0) top = mat[i][j-1];
                mat[i][j] = Math.min(top, left) + 1;
            }
        }

        int right = maxDistance, bottom = maxDistance;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (mat[i][j] == 0) continue;

                right = maxDistance;
                bottom = maxDistance;

                if (i+1 < m) right = mat[i+1][j];
                if (j+1 < n) bottom = mat[i][j+1];
                mat[i][j] = Math.min(mat[i][j], Math.min(right, bottom) + 1);
            }
        }
        
        return mat;
    }
}