class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> q = new LinkedList<>(); 
        boolean[] visited = new boolean[n * n + 1];
        
        q.offer(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int square = cur[0];
            int moves = cur[1];

            if (square == n * n) return moves; 

            for (int dice = 1; dice <= 6; dice++) {
                int next = square + dice;
                if (next > n * n) continue;

                int[] pos = getRowCol(next, n);
                int r = pos[0], c = pos[1];

                if (board[r][c] != -1) {
                    next = board[r][c]; 
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, moves + 1});
                }
            }
        }
        return -1;
    }

    private int[] getRowCol(int num, int n) {
        int quot = (num - 1) / n;
        int rem = (num - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : n - 1 - rem;
        return new int[]{row, col};
    }
}
