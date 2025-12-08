class Solution {
    public int majorityElement(int[] nums) {
        int major =0,freq =0;

        for(int num:nums){
            if(freq == 0) major = num;
            if(num == major) freq++;
            else freq--;
        }
        return major;
    }
}