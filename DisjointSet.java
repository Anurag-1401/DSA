class DisjointSet {

    int[] parent;
    int[] rank;
    int[] size;

    public DisjointSet(int n) {

        parent = new int[n];
        rank = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;   // initially self parent
            rank[i] = 0;
            size[i] = 1;     // each component size = 1
        }
    }

    // Find with Path Compression
    private int findParent(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]);
    }

    // Check if in same set
    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    // Union by Rank
    public void unionByRank(int u, int v) {

        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        }
        else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    // Union by Size
    public void unionBySize(int u, int v) {

        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
