class Solution {
    public int missingNumber(int[] nums) {
        int target =0,ans=0;

        for(int i=0;i<=nums.length;i++) target ^= i;
        for(int num:nums) ans ^= num; 

        return ans^target;
    }
}