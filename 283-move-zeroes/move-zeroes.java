class Solution {
    public void moveZeroes(int[] nums) {
        int a=0;

        for(int num : nums){
            if(num!=0) nums[a++] = num;
        }
        
        while(a<nums.length) {
            nums[a] = 0;
            a++;
        }
    }
}