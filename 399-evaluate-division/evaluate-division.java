class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            double val = values[i];
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0), dst = queries.get(i).get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                res[i] = -1.0;
            } else {
                res[i] = dfs(src, dst, graph, new HashSet<>(), 1.0);
            }
        }
        return res;
    }

    private double dfs(String cur, String target, Map<String, Map<String, Double>> graph, Set<String> visited, double prod) {
        if (cur.equals(target)) return prod;
        visited.add(cur);

        for (String nei : graph.get(cur).keySet()) {
            if (!visited.contains(nei)) {
                double ans = dfs(nei, target, graph, visited, prod * graph.get(cur).get(nei));
                if (ans != -1.0) return ans;
            }
        }
        return -1.0;
    }
}
