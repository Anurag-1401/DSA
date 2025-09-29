class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][] box = new boolean[9][9];

    public void solveSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                int num = ch - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);
                row[i][num] = true;
                column[j][num] = true;
                box[boxIndex][num]= true;
            }
        }

        sudoku(board, 0, 0);
    }

    public boolean sudoku(char[][] board, int r, int c){
        if(r == 9) return true;
        if(c == 9) return sudoku(board, r+1, 0);
        if(board[r][c] != '.') return sudoku(board, r, c+1);

        int b = (r / 3)*3 + (c/3);
        for(int d = 0; d < 9; d++){
            if(!row[r][d] && !column[c][d] && !box[b][d]){
                board[r][c] = (char) ('1' + d);
                row[r][d] = column[c][d] = box[b][d] = true;

                if(sudoku(board, r, c+1)) return true;

                board[r][c] = '.';
                row[r][d] = column[c][d] = box[b][d] = false;
            }
        }

        return false;
    }
}