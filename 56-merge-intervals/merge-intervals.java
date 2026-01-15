class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int max = -1,min = Integer.MAX_VALUE;

        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            if(interval[0] > max) max = interval[0];
            if(interval[0] < min) min = interval[0];
        } 

        int[] range = new int[max-min+1];
        for(int[] interval:intervals){
            range[interval[0]-min] = Math.max(range[interval[0]-min],interval[1]-min);
        }

        int start = 0,end=0;
        for(int i=0;i<range.length;i++){
            if(range[i] == 0) continue;
            if(i<=end) end = Math.max(end,range[i]);
            else{
                res.add(new int[]{start+min,end+min});
                start = i;
                end = range[i];
            }
        }
        res.add(new int[]{start+min,end+min});

        return res.toArray(new int[res.size()][]);
    }
}