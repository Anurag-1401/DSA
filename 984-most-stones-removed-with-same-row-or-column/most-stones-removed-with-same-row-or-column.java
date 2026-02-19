import java.util.*;

class Solution {

    int[] parent;
    int[] size;

    public int removeStones(int[][] stones) {

        int OFFSET = 10001;  // Safe shift for columns
        int MAX = 20005;

        parent = new int[MAX];
        size = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Set<Integer> usedNodes = new HashSet<>();

        // Step 1: Union row ↔ column
        for (int[] stone : stones) {

            int row = stone[0];
            int col = stone[1] + OFFSET;

            union(row, col);

            usedNodes.add(row);
            usedNodes.add(col);
        }

        // Step 2: Count components
        int components = 0;

        for (int node : usedNodes) {
            if (find(node) == node)
                components++;
        }

        return stones.length - components;
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
