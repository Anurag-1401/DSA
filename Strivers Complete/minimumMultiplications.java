class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {

        int MOD = 100000;

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[MOD];

        Arrays.fill(dist, -1);

        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            if (node == end)
                return dist[node];

            for (int num : arr) {

                int next = (node * num) % MOD;

                if (dist[next] == -1) {

                    dist[next] = dist[node] + 1;
                    q.offer(next);
                }
            }
        }

        return -1;
    }
}
