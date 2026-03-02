class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int l=1,r=nums[nums.length-1]-nums[0],mid=0,cows=0,lastPos=0,ans=0;

        while(l<=r){
            mid=l+(r-l)/2;

            cows=1;lastPos=nums[0];
            for(int i=0;i<nums.length;i++){
                if(nums[i]-lastPos >=mid) {
                    cows++;
                    lastPos=nums[i];
                    if(cows==k) break;
                }
            }
            if(cows>=k){
                ans = mid;
                l=mid+1;
            } else r=mid-1;
        }
        return ans;
    }
}
