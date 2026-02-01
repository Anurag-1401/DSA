class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        
        return Math.max(robber(nums,0,n-2),robber(nums,1,n-1));
    }

    private int robber(int[] n,int s,int e){
        int prev2 = 0,prev1=0;

        for(int i=s;i<=e;i++){
            int c = Math.max(n[i]+prev2,prev1);
            prev2 = prev1;
            prev1 = c;
        }
        return prev1;
    }
}