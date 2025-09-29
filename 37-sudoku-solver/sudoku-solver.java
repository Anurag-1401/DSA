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


// class Solution {
//     int[] rows = new int[9];
//     int[] cols = new int[9];
//     int[] boxes = new int[9];
//     char[][] board;
//     int[][] empties;
//     int emptyCount = 0;

//     public void solveSudoku(char[][] board) {
//         this.board = board;
//         empties = new int[81][2];
//         for (int r = 0; r < 9; r++) {
//             for (int c = 0; c < 9; c++) {
//                 char ch = board[r][c];
//                 if (ch == '.' || ch == '0') {
//                     empties[emptyCount++] = new int[]{r, c};
//                 } else {
//                     int d = ch - '0';
//                     int mask = 1 << d;
//                     rows[r] |= mask;
//                     cols[c] |= mask;
//                     boxes[boxIndex(r, c)] |= mask;
//                 }
//             }
//         }
//         backtrack(0);
//     }

//     private boolean backtrack(int idx) {
//         if (idx == emptyCount) return true;

//         int bestIdx = -1;
//         int bestOptions = 10;
//         for (int k = idx; k < emptyCount; k++) {
//             int r = empties[k][0], c = empties[k][1];
//             int used = rows[r] | cols[c] | boxes[boxIndex(r, c)];
//             int options = 9 - Integer.bitCount(used & 0x3FE);
//             if (options < bestOptions) {
//                 bestOptions = options;
//                 bestIdx = k;
//                 if (options == 1) break;
//             }
//         }

//         if (bestIdx != idx) {
//             int[] tmp = empties[idx];
//             empties[idx] = empties[bestIdx];
//             empties[bestIdx] = tmp;
//         }

//         int r = empties[idx][0], c = empties[idx][1];
//         int used = rows[r] | cols[c] | boxes[boxIndex(r, c)];
//         for (int d = 1; d <= 9; d++) {
//             int mask = 1 << d;
//             if ((used & mask) == 0) {
//                 rows[r] |= mask;
//                 cols[c] |= mask;
//                 boxes[boxIndex(r, c)] |= mask;
//                 board[r][c] = (char) ('0' + d);

//                 if (backtrack(idx + 1)) return true;

//                 rows[r] &= ~mask;
//                 cols[c] &= ~mask;
//                 boxes[boxIndex(r, c)] &= ~mask;
//                 board[r][c] = '.';
//             }
//         }

//         return false;
//     }

//     private int boxIndex(int r, int c) {
//         return (r / 3) * 3 + (c / 3);
//     }
// }