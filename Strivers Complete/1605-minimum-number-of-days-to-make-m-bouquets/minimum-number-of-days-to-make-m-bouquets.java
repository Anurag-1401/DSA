class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k > bloomDay.length) return -1;

        int l=1,r=0,f=0,b=0,mid=0;
        for(int d:bloomDay) r = Math.max(r,d);

        while(l<r){
            mid = l+(r-l)/2;

            f=0;b=0;
            for(int d:bloomDay){
                if(d<=mid){
                    f++;
                    if(f==k){
                        f=0;
                        b++;
                    }
                } else f=0;
            }
            if(b>=m) r=mid;
            else l=mid+1;
        }
        return l;
    }
}