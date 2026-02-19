import java.util.*;

class Solution {

    int[] parent;
    int[] size;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<String, Integer> emailToIndex = new HashMap<>();

        // Step 1: Build DSU connections
        for (int i = 0; i < n; i++) {

            List<String> acc = accounts.get(i);

            for (int j = 1; j < acc.size(); j++) {

                String email = acc.get(j);

                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    union(i, emailToIndex.get(email));
                }
            }
        }

        // Step 2: Group emails by parent
        Map<Integer, TreeSet<String>> merged = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {

            String email = entry.getKey();
            int index = entry.getValue();

            int root = find(index);

            merged
                .computeIfAbsent(root, k -> new TreeSet<>())
                .add(email);
        }

        // Step 3: Build final answer
        List<List<String>> res = new ArrayList<>();

        for (int root : merged.keySet()) {

            List<String> list = new ArrayList<>();

            list.add(accounts.get(root).get(0)); // Name
            list.addAll(merged.get(root));       // Emails

            res.add(list);
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
