class Solution {

    int[] parent;
    int[] size;

    public List<Integer> numOfIslands(int n, int m, int[][] A) {

        parent = new int[n * m];
        size = new int[n * m];

        for (int i = 0; i < n * m; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        boolean[][] land = new boolean[n][m];

        int count = 0;
        List<Integer> res = new ArrayList<>();

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] op : A) {

            int r = op[0];
            int c = op[1];

            // If already land → count unchanged
            if (land[r][c]) {
                res.add(count);
                continue;
            }

            land[r][c] = true;
            count++;   // New island

            int node = r * m + c;

            // Check 4 neighbors
            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m
                        && land[nr][nc]) {

                    int neigh = nr * m + nc;

                    if (find(node) != find(neigh)) {
                        union(node, neigh);
                        count--;  // Islands merged
                    }
                }
            }

            res.add(count);
        }

        return res;
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }
}
