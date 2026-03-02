class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n=arr.length-1,used=0;
        double l=0,r=arr[n]-arr[0],eps =1e-6,mid=0,gap=0;

        while(r-l>eps){
            mid=l+(r-l)/2;

            used=0;
            for(int i=0;i<n;i++){
                gap = arr[i+1]-arr[i];
                used+=(int) (gap/mid);
            }
            if(used<=k) r=mid;
            else l=mid;
        }
        return r;
    }
}
