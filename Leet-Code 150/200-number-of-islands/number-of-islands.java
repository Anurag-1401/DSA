class Solution {
    public int numIslands(char[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Stack<int[]> st = new Stack<>();
                    st.push(new int[]{i, j});
                    while (!st.isEmpty()) {
                        int[] cell = st.pop();
                        int r = cell[0], c = cell[1];
                        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != '1') continue;
                        grid[r][c] = '0'; 
                        st.push(new int[]{r + 1, c});
                        st.push(new int[]{r - 1, c});
                        st.push(new int[]{r, c + 1});
                        st.push(new int[]{r, c - 1});
                    }
                }
            }
        }
        return count;
    }
}
