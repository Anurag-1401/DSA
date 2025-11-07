class Solution {
    public int search(int[] nums, int t) {
        int mid=0,l=0,r=nums.length-1;

        while(l<=r){
            mid = l+(r-l)/2;

            if(nums[mid] == t) return mid;

            if(nums[l]<=nums[mid]){
                if(t>= nums[l] && t< nums[mid]) r=mid-1;
                else l=mid+1;
            } else{
                if(t > nums[mid] && t<=nums[r]) l = mid+1;
                else r= mid-1;
            }
        }
        return -1;
    }
}