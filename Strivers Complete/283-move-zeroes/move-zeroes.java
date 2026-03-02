class Solution {
    public void moveZeroes(int[] nums) {
        int a =0;

        for(int num : nums){
            if(num !=0) nums[a++] = num;
        }

        while(a<nums.length) nums[a++] = 0;

        // for(int i=0, j=0;i<nums.length;i++)
        // {
        //     if(nums[i]==0)
        //     {
        //         continue;
        //     }
        //     else
        //     {
        //         int temp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = temp;
        //         j++;
        //     }
        // }  
    }
}