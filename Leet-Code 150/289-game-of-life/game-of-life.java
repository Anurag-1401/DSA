class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;

        int[][] dirs = {
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;

                for (int[] d : dirs) {
                    int r = i + d[0], c = j + d[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        if (Math.abs(board[r][c]) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; 
                }

                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
