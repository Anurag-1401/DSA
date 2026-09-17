class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int i = 0;
        int n = buildings.length;
        int prevHeight = 0;

        while (i < n || !maxHeap.isEmpty()) {
            int currentX;

            if (maxHeap.isEmpty()) {
                currentX = buildings[i][0];
            } else if (i == n) {
                currentX = maxHeap.peek()[1];
            } else {
                currentX = Math.min(
                        buildings[i][0],
                        maxHeap.peek()[1]
                );
            }

            while (i < n && buildings[i][0] == currentX) {
                maxHeap.offer(new int[]{
                        buildings[i][2],
                        buildings[i][1]
                });
                i++;
            }

            while (!maxHeap.isEmpty() &&
                    maxHeap.peek()[1] <= currentX) {
                maxHeap.poll();
            }

            int currentHeight =
                    maxHeap.isEmpty() ? 0 : maxHeap.peek()[0];

            if (currentHeight != prevHeight) {
                result.add(Arrays.asList(currentX, currentHeight));
                prevHeight = currentHeight;
            }
        }

        return result;
    }
}