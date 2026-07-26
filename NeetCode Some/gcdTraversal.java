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

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) parent[pa] = pb;
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {

        int n = nums.length;

        if (n == 1) return true;

        for (int num : nums) {
            if (num == 1) return false;
        }

        DSU dsu = new DSU(n);
        Map<Integer, Integer> factorMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            for (int f = 2; f * f <= num; f++) {
                if (num % f == 0) {

                    if (factorMap.containsKey(f)) {
                        dsu.union(i, factorMap.get(f));
                    } else {
                        factorMap.put(f, i);
                    }

                    while (num % f == 0) {
                        num /= f;
                    }
                }
            }

            if (num > 1) {
                if (factorMap.containsKey(num)) {
                    dsu.union(i, factorMap.get(num));
                } else {
                    factorMap.put(num, i);
                }
            }
        }

        int root = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) return false;
        }

        return true;
    }
}
