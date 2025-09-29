class Solution {
    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = cols[j][num] = boxes[boxIndex(i, j)][num] = true;
                }
            }
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int r, int c) {
        if (r == 9) return true;

        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c + 1) % 9;

        if (board[r][c] != '.') {
            return backtrack(board, nextR, nextC);
        }

        for (int num = 1; num <= 9; num++) {
            int box = boxIndex(r, c);
            if (!rows[r][num] && !cols[c][num] && !boxes[box][num]) {
                board[r][c] = (char) (num + '0');
                rows[r][num] = cols[c][num] = boxes[box][num] = true;

                if (backtrack(board, nextR, nextC)) return true;

                board[r][c] = '.';
                rows[r][num] = cols[c][num] = boxes[box][num] = false;
            }
        }
        return false;
    }

    private int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
