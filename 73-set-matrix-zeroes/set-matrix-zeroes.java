class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length,c=matrix[0].length;
        HashSet<Integer> row = new HashSet<>(), col = new HashSet<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int rowNo : row){
            for(int colNo=0;colNo<c;colNo++){
            matrix[rowNo][colNo] = 0;
            }
        }

         for(int colNo : col){
            for(int rowNo=0;rowNo<r;rowNo++){
            matrix[rowNo][colNo] = 0;
            }
        }

    }
}