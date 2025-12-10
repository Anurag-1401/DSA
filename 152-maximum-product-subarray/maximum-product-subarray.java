class Solution {
    public int maxProduct(int[] nums) {
        int min=nums[0],max=nums[0],ans=nums[0],temp=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                temp = max;
                max=min;
                min=temp;
            }

            max = Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],nums[i]*min);

            if(max>ans) ans = max; 
        }
        return ans;
    }
}