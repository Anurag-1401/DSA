class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0,r=0,mid=0,ans=0,cnt=0,sum=0;

        for(int n:nums){
            l= Math.max(l,n);
            r+=n;
        }

        while(l<=r){
            mid=l+(r-l)/2;

            cnt=1;sum=0;
            for(int n:nums){
                if(sum+n>mid){
                    cnt++;
                    sum=0;
                }
                sum+=n;
            }
            if(cnt<=k){
                ans = mid;
                r=mid-1;
            } else l=mid+1;
        }
        return ans;
    }
}