class Solution {
    public int NthRoot(int N, int M) {
        int mid=0,l=1,r=M;
        long  p=0;

        while(l<=r){
            mid = l+(r-l)/2;

            p= power(mid,N,M);

            if(p==M) return mid;
            else if(p<M) l=mid+1;
            else r=mid-1; 
        }
        return -1;
    }

    private long power(int mid,int N,int M){
        long ans=1;
        for(int i=1;i<=N;i++){
            ans*=mid;
            if(ans>M) return ans;
        }
        return ans;
    }
}
