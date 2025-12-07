class Solution {
    public boolean search(int[] nums, int t) {
        int mid=0,l=0,r=nums.length-1;

        while(l<=r){
            mid = l+(r-l)/2;

            if(nums[mid] == t) return true;

            if(nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;r--;
            }

            else if(nums[l]<=nums[mid]){
                if(t>= nums[l] && t< nums[mid]) r=mid-1;
                else l=mid+1;
            } else{
                if(t > nums[mid] && t<=nums[r]) l = mid+1;
                else r= mid-1;
            }
        }
        return false;
    }
}