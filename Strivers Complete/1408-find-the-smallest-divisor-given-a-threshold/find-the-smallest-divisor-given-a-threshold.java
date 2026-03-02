class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1,r=0,mid=0,sum=0;

        for(int n:nums) r = Math.max(n,r);

        while(l<r){
            mid = l+(r-l)/2;

            sum=0;
            for(int n:nums) sum+=(n-1+mid)/mid;
            if(sum<=threshold) r=mid;
            else l = mid+1;
        }
        return l;
    }
}