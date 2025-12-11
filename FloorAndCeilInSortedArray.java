class Solution {
    public int[] getFloorAndCeil(int[] nums, int x) {
       int mid=0,l=0,r=nums.length-1,floor=-1,ceil=-1;

       while(l<=r){
        mid = l+(r-l)/2;

        if(nums[mid] == x) return new int[]{x,x};
        else if(nums[mid]<x) {
            floor = nums[mid];
            l=mid+1;
        } else {
            ceil = nums[mid];
            r=mid-1;
        }
       }
       return new int[]{floor,ceil};
    }
}
