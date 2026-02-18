class Solution {
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for (int[] row : dist)
            Arrays.fill(row, (int)1e9);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == rows-1 && c == cols-1)
                return effort;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols) {

                    int weight = Math.abs(
                            heights[r][c] - heights[nr][nc]);

                    int newEffort = Math.max(effort, weight);

                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}
