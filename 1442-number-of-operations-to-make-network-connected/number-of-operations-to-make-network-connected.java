class Solution {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for (int[] c : connections) {
            if (union(c[0], c[1], parent, rank)) {
                components--;
            }
        }

        return components - 1;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private boolean union(int x, int y, int[] parent, int[] rank) {
        int px = find(x, parent);
        int py = find(y, parent);

        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
}