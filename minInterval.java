class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[][] q = new int[n][2];

        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] result = new int[n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int i = 0;

        for (int[] query : q) {
            int val = query[0];
            int idx = query[1];

            while (i < intervals.length && intervals[i][0] <= val) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int len = end - start + 1;

                minHeap.offer(new int[]{len, end});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < val) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                result[idx] = -1;
            } else {
                result[idx] = minHeap.peek()[0];
            }
        }

        return result;
    }
}
