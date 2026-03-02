class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return check(0,nums,k);
    }

    private boolean check(int i,int[] nums,int k){
        if(k==0) return true;

        if(i==nums.length || k<0) return false;

        if(check(i+1,nums,k)) return true;

        if(check(i+1,nums,k-nums[i])) return true;

        return false;
    }
}
