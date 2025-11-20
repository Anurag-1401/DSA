// class Solution {
//     boolean[][] row = new boolean[9][9];
//     boolean[][] column = new boolean[9][9];
//     boolean[][] box = new boolean[9][9];

//     public void solveSudoku(char[][] board) {

//         for(int i = 0; i < 9; i++){
//             for(int j = 0; j < 9; j++){
//                 char ch = board[i][j];
//                 if(ch == '.') continue;
//                 int num = ch - '1';
//                 int boxIndex = (i / 3) * 3 + (j / 3);
//                 row[i][num] = true;
//                 column[j][num] = true;
//                 box[boxIndex][num]= true;
//             }
//         }

//         sudoku(board, 0, 0);
//     }

//     public boolean sudoku(char[][] board, int r, int c){
//         if(r == 9) return true;
//         if(c == 9) return sudoku(board, r+1, 0);
//         if(board[r][c] != '.') return sudoku(board, r, c+1);

//         int b = (r / 3)*3 + (c/3);
//         for(int d = 0; d < 9; d++){
//             if(!row[r][d] && !column[c][d] && !box[b][d]){
//                 board[r][c] = (char) ('1' + d);
//                 row[r][d] = column[c][d] = box[b][d] = true;

//                 if(sudoku(board, r, c+1)) return true;

//                 board[r][c] = '.';
//                 row[r][d] = column[c][d] = box[b][d] = false;
//             }
//         }

//         return false;
//     }
// }






class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowHas = new boolean[9][9]; //row[i][x]:i行有数字x
        boolean[][] colHas = new boolean[9][9];
        boolean[][][] subBoxHas = new boolean[3][3][9]; //subBoxHas[i][j][x], (i, j)宫有x
        List<int[]> emptyPos = new ArrayList<>();//待填的位置,'.'

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyPos.add(new int[] {i, j});
                } else {
                    int x = board[i][j] - '1';//convert to 0-8
                    rowHas[i][x] = colHas[j][x] = subBoxHas[i / 3][j / 3][x] = true;
                }
            }
        }

        PriorityQueue<int[]> emptyPQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] pos : emptyPos) {
            int i = pos[0];
            int j = pos[1];
            int candidates = getCandidates(i, j, rowHas, colHas, subBoxHas);
            emptyPQ.offer(new int[] {candidates, i, j}); //待定数字个数最少的在堆顶
        }
        dfs(board, rowHas, colHas, subBoxHas, emptyPQ);
    }

    private int getCandidates(int i, int j, boolean[][] rowHas, boolean[][] colHas, boolean[][][] subBoxHas) {
        int candidates = 9;
        for (int x = 0; x < 9; x++) {
            if (rowHas[i][x] || colHas[j][x] || subBoxHas[i / 3][j / 3][x]) {
                candidates--;
            }
        }
        return candidates;
    }

    private boolean dfs(char[][] board, boolean[][] rowHas, boolean[][] colHas, boolean[][][] subBoxHas, PriorityQueue<int[]> emptyPQ) {
        if (emptyPQ.isEmpty()) {
            return true;
        }
        int[] top = emptyPQ.poll();
        int i = top[1], j = top[2];

        int candidates = 0; //受之前填入数字的影响，重新计算待定数字
        for (int x = 0; x < 9; x++) {
            if (rowHas[i][x] || colHas[j][x] || subBoxHas[i / 3][j / 3][x]) {
                continue;
            }
            board[i][j] = (char)('1' + x);
            rowHas[i][x] = colHas[j][x] = subBoxHas[i / 3][j / 3][x] = true;

            if (dfs(board, rowHas, colHas, subBoxHas, emptyPQ)) return true;
            rowHas[i][x] = colHas[j][x] = subBoxHas[i / 3][j / 3][x] = false;
            candidates++;
        }
        emptyPQ.offer(new int[] {candidates, i, j});
        return false;
    }
}