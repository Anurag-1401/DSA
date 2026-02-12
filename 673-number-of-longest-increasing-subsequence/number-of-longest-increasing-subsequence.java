class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] len = new int[n];
        int[] count = new int[n];

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            len[i] = 1;
            count[i] = 1;

            for (int prev = 0; prev < i; prev++) {

                if (nums[i] > nums[prev]) {

                    if (len[prev] + 1 > len[i]) {
                        len[i] = len[prev] + 1;
                        count[i] = count[prev];
                    }
                    else if (len[prev] + 1 == len[i]) {
                        count[i] += count[prev];
                    }
                }
            }

            maxLen = Math.max(maxLen, len[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                result += count[i];
            }
        }

        return result;
    }
}
