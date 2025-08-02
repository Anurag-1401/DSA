class Solution {
    public int jump(int[] nums) {
         if (nums.length == 1) return 0;

        int range = 0;
        int jump = 0;
        int last = 0;

        for (int i = 0; i < nums.length-1; i++) {

            range = Math.max(range, i + nums[i]);

            if (i == last) {
                jump++;
                last = range;
            }
        }

        return jump;
    }
}