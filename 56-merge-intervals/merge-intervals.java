class Solution {
    public int[][] merge(int[][] intervals) {
        int max = -1,min = Integer.MAX_VALUE;

        LinkedList<int[]> ans = new LinkedList<>();

        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>max) max = intervals[i][0];
            if(intervals[i][0]<min) min = intervals[i][0];
        }

        int[] range = new int[max-min+1];
        for(int i=0;i<intervals.length;i++){
            range[intervals[i][0]-min] = Math.max(intervals[i][1]-min,range[intervals[i][0]-min]);
        }

        int start=0,end=0;
        for(int i=0;i<range.length;i++){
            if(range[i] == 0) continue;
            if(i<=end) end = Math.max(end,range[i]);
            else {
                ans.add(new int[]{start+min,end+min});
                start = i;
                end = range[i];
            }
        }
        ans.add(new int[]{start+min,end+min});

        return ans.toArray(new int[ans.size()][]);
    }
}