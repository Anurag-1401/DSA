class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.add(new int[] {0, 0, 0});
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int effort = top[0];
            int r = top[1];
            int c = top[2];
            if (r == n - 1 && c == m - 1) {
                return effort;
            }
            if (effort > dist[r][c]) continue;
            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newEffort = Math.max(effort,Math.abs(heights[r][c] - heights[nr][nc]));
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new int[] {newEffort, nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}