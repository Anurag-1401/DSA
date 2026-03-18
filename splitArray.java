class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;

        for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            int cnt = 1, sum = 0;

            for (int n : nums) {
                if (sum + n > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += n;
            }

            if (cnt <= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
