class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0,maxC=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1) count++;
            else {
                if(count>maxC) maxC = count;
                count =0;
            }
        }
        return maxC > count ? maxC : count;
    }
}