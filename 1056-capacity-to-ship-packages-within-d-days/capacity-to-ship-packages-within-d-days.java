class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,h=0,mid=0;
        for(int w:weights){
            l = Math.max(l,w);
            h+=w;
        }

        while(l<h){
            mid = l+(h-l)/2;
            int need=1,sum=0;
            
            for(int w:weights){
                if(sum+w > mid) {
                    need++;
                    sum=0;
                } 
                sum+=w;
            }

            if(need<=days) h = mid;
            else l = mid+1;
        }
        return l;
    }
}