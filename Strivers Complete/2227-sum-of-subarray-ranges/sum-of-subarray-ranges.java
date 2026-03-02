class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long result = 0;
        
        int[] minStack = new int[n];
        int[] maxStack = new int[n];
        int minTop = -1, maxTop = -1;
        
        for (int i = 0; i <= n; i++) {
            while (minTop >= 0 && (i == n || nums[minStack[minTop]] >= nums[i])) {
                int j = minStack[minTop--];
                long left = minTop < 0 ? j + 1 : j - minStack[minTop];
                long right = i - j;
                result -= (long) nums[j] * left * right;
            }
            
            while (maxTop >= 0 && (i == n || nums[maxStack[maxTop]] <= nums[i])) {
                int j = maxStack[maxTop--];
                long left = maxTop < 0 ? j + 1 : j - maxStack[maxTop];
                long right = i - j;
                result += (long) nums[j] * left * right;
            }
            
            if (i < n) {
                minStack[++minTop] = i;
                maxStack[++maxTop] = i;
            }
        }
        
        return result;
    }
}