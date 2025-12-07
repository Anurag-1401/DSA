class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length,total=0,array=0;

        for(int i=0;i<=n;i++) total ^= i;
        for(int num:nums) array ^= num;
        return total^array;
    }
}