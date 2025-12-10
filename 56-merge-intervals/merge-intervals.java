class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> ans = new LinkedList<>();

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for(int[] interval:intervals){
            if(ans.isEmpty() || ans.getLast()[1]<interval[0]) ans.add(interval);
            else ans.getLast()[1] = Math.max(ans.getLast()[1],interval[1]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}