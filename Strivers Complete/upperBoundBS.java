class Solution {
    public int upperBound(int[] nums, int x) {
        int mid=0,l=0,r=nums.length-1,ans=nums.length;

        while(l<=r){
            mid = l+(r-l)/2;

            if(nums[mid]>x){
                ans = mid;
                r=mid-1;
            } else l=mid+1;
        }
        return ans;
    }
}
