import java.util.*;

class Solution {

    int[] parent;
    int[] size;

    public int makeConnected(int n, int[][] connections) {

        // Step 1: Minimum edges check
        if (connections.length < n - 1)
            return -1;

        // Step 2: Initialize DSU
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Step 3: Union edges
        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            if (!isConnected(u, v)) {
                unionBySize(u, v);
            }
        }

        // Step 4: Count components
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (findParent(i) == i)
                components++;
        }

        return components - 1;
    }

    private int findParent(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]); // path compression
    }

    private boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }

    private void unionBySize(int u, int v) {

        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
