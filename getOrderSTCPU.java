class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] newTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }

        Arrays.sort(newTasks, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
        );

        int[] result = new int[n];
        int i = 0, idx = 0;
        long time = 0;

        while (idx < n) {

            while (i < n && newTasks[i][0] <= time) {
                minHeap.add(newTasks[i]);
                i++;
            }

            if (minHeap.isEmpty()) {
                time = newTasks[i][0];
            } else {
                int[] task = minHeap.poll();
                time += task[1];
                result[idx++] = task[2];
            }
        }

        return result;
    }
}
