class Solution {
    public int longestSubarray(int[] nums, int k) {
       int maxL=0,target=0,j=0;

       for(int i=0;i<nums.length;i++){

        target += nums[i];

        while(target > k && j<=i) {
            target -= nums[j++];
        }

        if(target == k) maxL = Math.max(maxL,i-j+1);
        
       }

       return maxL;
    }
}
