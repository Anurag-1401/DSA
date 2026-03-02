class Solution {
    public int rowWithMax1s(int[][] mat) {
       int m=mat.length,n=mat[0].length,mid=0;
       int maxRow = -1,maxOnes =0,first=-1,ones=0;
       int l=0,r=n-1;

       for(int i=0;i<m;i++){
            l=0;r=n-1;first=-1;
            while(l<=r){
                mid=l+(r-l)/2;

                if(mat[i][mid] == 1){
                    first = mid;
                    r=mid-1;
                } else l=mid+1;
            }
            if(first != -1){
                ones = n-first;
                if(ones>maxOnes){
                    maxOnes = ones;
                    maxRow = i;
                }
            }
       }
       return maxRow;
    }
}
