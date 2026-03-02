class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dir = {1, 1, -1, -1, 1, 0, -1, 0, 1};
        int n = grid.length;
        int dl = dir.length;

        int[] q = new int[n * n];
        int head = 0, tail = 0;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] == 1)
            return -1;

        q[tail++] = 0;
        grid[0][0] = 1;

        int c = 1;
        boolean isFounded = false;
        outer_loop:
        while (head != tail) {
            int size = tail - head;

            for (int ign = 0; ign < size; ign++) {
                int val = q[head++];
                int i = val / n, j = val - i * n;

                if (i == n - 1 && j == n - 1) {
                    isFounded = true;
                    break outer_loop;
                }

                for (int d = 0; d < dl - 1; d++) {
                    int ni = i + dir[d], nj = j + dir[d + 1];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= n || grid[ni][nj] == 1)
                        continue;

                    q[tail++] = ni * n + nj;
                    grid[ni][nj] = 1;
                }
            }

            c++;
        }

        return isFounded ? c : -1;

    }
}