class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x ^= n;   // XOR cancels out duplicates
        }
        return x;
    }
}
