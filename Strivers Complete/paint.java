class Solution {
    public int paint(int A, int B, int[] C) {
        int mod = 10000003;
        int l=0,r=0,mid=0,ans=0,pai=0,load=0;

        for(int c:C){
            l=Math.max(c,l);
            r+=c;
        }

        ans = r;
        while(l<=r){
            mid = l+(r-l)/2;

            pai=1;load=0;
            for(int c:C){
                if(load+c>mid){
                    pai++;
                    load=0;
                }
                load+=c;
            }

            if(pai<=A){
                ans = mid;
                r=mid-1;
            }else l=mid+1;

        }
        ans = (ans % mod * B % mod) % mod;
        return (int) ans;
    }
}
