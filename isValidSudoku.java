class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch == '.') continue;

                int n = ch - '1';
                int idx = (i/3)*3+(j/3);

                if(rows[i][n] || cols[j][n] || boxes[idx][n]) return false;

                rows[i][n] =true;
                cols[j][n] =true; 
                boxes[idx][n] = true;
            }
        }
        return true;
    }
}
