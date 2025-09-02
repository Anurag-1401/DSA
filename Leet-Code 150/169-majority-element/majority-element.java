class Solution {
    public int majorityElement(int[] nums) {
        int major = 0;
        int majority = 0;
        for(int i=0;i<nums.length;i++){
                if(majority == 0){
                    major = nums[i];
                }

                if(nums[i] == major){
                majority++;
                } else {
                    majority--;
                }

        }

        return major;
    }
}