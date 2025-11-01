class Solution {
    public boolean canJump(int[] nums) {
         if (nums.length == 1) return true;

        int range = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > range) return false;

            range = Math.max(range, i + nums[i]);

            if (range >= nums.length - 1) return true;
        }

        return false;
    }
}