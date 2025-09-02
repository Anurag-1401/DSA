class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> stack = new LinkedList<>();

        for (int[] interval : intervals) {
            if (stack.isEmpty() || stack.getLast()[1] < interval[0]) {
                stack.add(interval); 
            } else {
                stack.getLast()[1] = Math.max(stack.getLast()[1], interval[1]);
            }
        }

        return stack.toArray(new int[stack.size()][]);
    }
}