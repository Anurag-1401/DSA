class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        int i = 0;

        // 1. move them
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            ans.add(intervals[i]);
            i++;
        }

        // 2. merge
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        // 3. add the rest
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }

        int[][] a = new int[ans.size()][2];
        for (int j = 0; j < a.length; j++) {
            a[j] = ans.get(j);
        }

        return a;
    }
}