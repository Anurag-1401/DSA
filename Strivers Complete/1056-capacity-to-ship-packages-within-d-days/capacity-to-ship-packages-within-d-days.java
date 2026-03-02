class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,r=0,mid=0,need=0,sum=0;

        for(int w:weights){
            l=Math.max(l,w);
            r+=w;
        }

        while(l<r){
            mid=l+(r-l)/2;

            need=1;sum=0;
            for(int w:weights){
                if(sum+w>mid){
                    need++;
                    sum=0;
                }
                sum+=w;
            }
            if(need<=days) r=mid;
            else l=mid+1;
        }
        return l;
    }
}