class Solution {
    public int frogJump(int[] heights) {
        int n = heights.length;

        int prev = 0,prev1=0;

        for(int i=1;i<n;i++){
            int one = prev + Math.abs(heights[i] - heights[i-1]);
            
            int two = Integer.MAX_VALUE;
            if(i>1) two = prev1 +  Math.abs(heights[i] - heights[i-2]);

            int curr = Math.min(one,two);
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}
