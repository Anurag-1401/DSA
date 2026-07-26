class Solution {
    static int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return false;

            union(pu, pv);
        }

        return true;
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        parent[x] = y;
    }
}
