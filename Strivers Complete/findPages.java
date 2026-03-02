class Solution {
    public int findPages(int[] nums, int m) {
        int l=0,r=0,mid=0,stu=0,pages=0,ans=0;
        
        for(int n:nums){
            l = Math.max(n,l);
            r+=n;
        }

        while(l<=r){
            mid = l+(r-l)/2;

            stu=1;pages=0;
            for(int n:nums){
                if(pages+n>mid){
                    stu++;
                    pages=0;
                }
                pages+=n;
            }
            if(stu<=m){
                ans = mid;
                r=mid-1;
            } else l=mid+1;
        }
        return ans;
    }
}
