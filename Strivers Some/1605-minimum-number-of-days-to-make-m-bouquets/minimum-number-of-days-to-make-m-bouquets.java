class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k > bloomDay.length) return -1;

        int low=1,high=0,mid=0;
        for(int d:bloomDay) high = Math.max(high,d);

        while(low<high){
            mid = low+(high-low)/2;

            int f=0,b=0;
            
            for(int d:bloomDay){
                if(d<=mid){
                    f++;
                    if(f==k){
                        f=0;
                        b++;
                    }
                }else f=0;
            }
            if(b>=m) high = mid;
                else low = mid+1;
        }
        return low;
    }
}