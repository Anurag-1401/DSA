class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return count(0,nums,k);
    }

    private int count(int i,int[] nums,int k){
        if(k==0) return 1;

        if(k<0 || i == nums.length) return 0;

        int pick = count(i+1,nums,k);
        int notPick = count(i+1,nums,k-nums[i]);

        return pick+notPick;
    }
}
