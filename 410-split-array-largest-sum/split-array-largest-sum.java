class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0, mid = 0, ans = 0;
        for (int n : nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low <= high) {
            mid = low + (high - low) / 2;
            int cnt = 1, sum = 0;

            for (int n : nums) {
                if (sum + n > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += n;
            }

            if (cnt <= k) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }
}
