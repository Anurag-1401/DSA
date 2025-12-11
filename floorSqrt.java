class Solution {
    public long floorSqrt(int n) {
      if(n==0 || n==1) return 1;

      int mid=0,l=0,r=n;
      long sq = 0,ans=-1;

        while(l<=r){
            mid = l+(r-l)/2;

            sq =(long) mid*mid;

            if(sq == n) return mid;
            else if(sq<n){
                ans = mid;
                l=mid+1;
            } else{
                r=mid-1;
            }
        }
        return ans;
    }
}
