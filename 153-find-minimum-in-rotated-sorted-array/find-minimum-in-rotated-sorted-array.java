class Solution {
    public int findMin(int[] nums) {
        int mid=0,l=0,r=nums.length-1;

        while(l<r){
            mid = l+(r-l)/2;

            if(nums[mid]>nums[r]) l=mid+1;
            else r=mid;
        }
        return nums[l];
    }
}