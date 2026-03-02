class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int[] count = new int[nums.length + 1];
        int total = 0,result = 0;
        count[0] = 1;

        for(int i : nums) {
            total += i & 1;
            if(total - k >= 0) {
                result += count[total - k];
            }
            count[total]++;
        }
        return result;
    }
}