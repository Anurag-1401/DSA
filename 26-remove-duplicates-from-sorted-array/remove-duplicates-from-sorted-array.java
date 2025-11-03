class Solution {
    public int removeDuplicates(int[] nums) {
        int a =0,b=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i-1] == nums[i]) b++;
            else {
                a++;
                b++;
                nums[a] = nums[b];
            }
        }
        return a+1;
    }
}