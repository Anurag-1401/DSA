class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = find(nums,target,true);
        int l = find(nums,target,false);

        return new int[] {f,l};
    }
    private int find(int[] nums, int target,boolean access){
        int l=0,r=nums.length-1,mid=0,a=-1;

        while(l<=r){
            mid = l+(r-l)/2;

            if(nums[mid] == target){
                a=mid;
                if(access) r = mid-1;
                else l = mid+1;
            } else if(nums[mid]<target) l=mid+1;
            else r = mid-1;
        }
        return a;
    }
}