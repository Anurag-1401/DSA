class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            parent[pa] = pb;
            return true;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int m = edges.length;

        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int baseCost = kruskal(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int costWithout = kruskal(n, newEdges, i, -1);
            if (costWithout > baseCost) {
                critical.add(newEdges[i][3]);
            } else {
                int costWith = kruskal(n, newEdges, -1, i);
                if (costWith == baseCost) {
                    pseudo.add(newEdges[i][3]);
                }
            }
        }

        return Arrays.asList(critical, pseudo);
    }

    private int kruskal(int n, int[][] edges, int skipEdge, int pickEdge) {
        DSU dsu = new DSU(n);
        int cost = 0;

        if (pickEdge != -1) {
            int[] e = edges[pickEdge];
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skipEdge) continue;

            int[] e = edges[i];
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
            }
        }

        int root = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) return Integer.MAX_VALUE;
        }

        return cost;
    }
}
