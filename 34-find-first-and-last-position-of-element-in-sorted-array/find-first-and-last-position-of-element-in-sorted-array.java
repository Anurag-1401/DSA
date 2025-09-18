class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int left=0,right=nums.length-1,mid=0;

        while(left<=right){
            mid = (left+right) >>> 1;
            if(nums[mid] >= target) right = mid-1;
            else left = mid+1;
            if(nums[mid] == target) ans[0] = mid;
        }

        left=0;right=nums.length-1;
        
         while(left<=right){
            mid = (left+right) >>> 1;
            if(nums[mid] <= target) left = mid+1;
            else right = mid-1;
            if(nums[mid] == target) ans[1] = mid;
        }
        return ans;
    }
}