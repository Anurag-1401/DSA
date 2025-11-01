class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length,c=matrix[0].length,temp=0;

        for(int i=0;i<r;i++){
            for(int j=i;j<c;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c/2;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][c-1-j];
                matrix[i][c-1-j] = temp;
            }
        }
    }
}