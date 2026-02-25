class Solution {

    int n;
    int[][] grid;
    Map<Integer, Integer> sizeMap = new HashMap<>();

    public int largestIsland(int[][] grid) {

        this.grid = grid;
        this.n = grid.length;

        int id = 2; // Start labeling from 2
        int max = 0;

        // Step 1: Label islands
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1) {
                    int size = dfs(r, c, id);
                    sizeMap.put(id, size);
                    max = Math.max(max, size);
                    id++;
                }
            }
        }

        // Step 2: Try flipping zeros
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 0) {

                    Set<Integer> seen = new HashSet<>();
                    int newSize = 1;

                    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

                    for (int[] d : dir) {

                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr >= 0 && nc >= 0 && nr < n && nc < n
                                && grid[nr][nc] > 1) {

                            int neighId = grid[nr][nc];

                            if (!seen.contains(neighId)) {
                                newSize += sizeMap.get(neighId);
                                seen.add(neighId);
                            }
                        }
                    }

                    max = Math.max(max, newSize);
                }
            }
        }

        return max;
    }

    private int dfs(int r, int c, int id) {

        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1)
            return 0;

        grid[r][c] = id;

        return 1
            + dfs(r + 1, c, id)
            + dfs(r - 1, c, id)
            + dfs(r, c + 1, id)
            + dfs(r, c - 1, id);
    }
}