class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1,r=0;

        for(int p:piles) r = Math.max(r,p);

        while(l<r){
            int mid = l+(r-l)/2;
            int time=0;
            for(int p:piles) time+=(p+mid-1)/mid;

            if(time>h) l = mid+1;
            else r = mid;
        }
        return l;
    }
}
