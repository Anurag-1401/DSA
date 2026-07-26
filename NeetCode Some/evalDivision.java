class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                res[i] = -1.0;
            } else if (src.equals(dest)) {
                res[i] = 1.0;
            } else {
                res[i] = dfs(graph, src, dest, 1.0, new HashSet<>());
            }
        }

        return res;
    }

    private static double dfs(Map<String, Map<String, Double>> graph,
                              String curr, String target,
                              double product, Set<String> visited) {

        visited.add(curr);

        if (curr.equals(target)) return product;

        for (String nei : graph.get(curr).keySet()) {
            if (!visited.contains(nei)) {
                double result = dfs(graph, nei, target,
                                    product * graph.get(curr).get(nei),
                                    visited);

                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }
}
