class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            long s1 = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (s1 > target) break;
            s1 = (long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1];
            if (s1 < target) continue;

            long t1 = (long) target - nums[i];
            for (int j = i + 1; j < n - 2; j ++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long s2 = (long) nums[j] + nums[j + 1] + nums[j + 2];
                if (s2 > t1) break;
                s2 = (long) nums[j] + nums[n - 2] + nums[n - 1];
                if (s2 < t1) continue;

                long t2 = (long) target - nums[i] - nums[j];
                for (int k = j + 1, l = n - 1; k < l; ) {
                    long sum = (long) nums[k] + nums[l];
                    if (sum == t2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < t2) k++;
                    else l--;
                }
            }
        }
        return res;
    }
}