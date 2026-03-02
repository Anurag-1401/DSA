class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
        int mid=0,l=0,r=nums.size()-1;

        while(l<r){
            mid = l+(r-l)/2;
        
            if(nums.get(mid)>nums.get(r)) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
