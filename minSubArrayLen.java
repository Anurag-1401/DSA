class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=Integer.MAX_VALUE,l=0,sum=0;

        for(int r=0;r<nums.length;r++){
            sum+=nums[r];

            while(l<=r && sum >= target){
                len = Math.min(len,r-l+1);
                sum-=nums[l++];
            }
        }
        return len== Integer.MAX_VALUE ? 0 : len;
    }
}
