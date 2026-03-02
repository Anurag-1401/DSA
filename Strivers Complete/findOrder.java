class Solution {
    public String findOrder(String[] dict, int N, int K) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[K];

        for (int i = 0; i < N - 1; i++) {

            String w1 = dict[i];
            String w2 = dict[i + 1];

            int len = Math.min(w1.length(), w2.length());
            boolean foundDifference = false;

            for (int j = 0; j < len; j++) {

                if (w1.charAt(j) != w2.charAt(j)) {

                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';

                    adj.get(u).add(v);
                    indegree[v]++;

                    foundDifference = true;
                    break; 
                }
            }

            if (!foundDifference && w1.length() > w2.length())
                return "";
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        StringBuilder topo = new StringBuilder();

        while (!q.isEmpty()) {

            int node = q.poll();
            topo.append((char)(node + 'a'));

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        if (topo.length() < K)
            return "";

        return topo.toString();
    }
}
