class Solution {
    static int[] parent;

    public static int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return e;
            }

            union(pu, pv);
        }

        return new int[0];
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
