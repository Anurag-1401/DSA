class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;

        if (sum % k != 0) return false;

        int target = sum / k;

        Arrays.sort(nums);
        reverse(nums);

        int[] bucket = new int[k];

        return backtrack(nums, 0, bucket, target);
    }

    private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            return true;
        }

        int current = nums[index];

        for (int i = 0; i < bucket.length; i++) {

            if (bucket[i] + current > target) continue;

            bucket[i] += current;

            if (backtrack(nums, index + 1, bucket, target)) return true;

            bucket[i] -= current;

            if (bucket[i] == 0) break;
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
