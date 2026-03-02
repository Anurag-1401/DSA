class Solution {
    public int findMedian(int[][] matrix) {
      int m=matrix.length,n=matrix[0].length,mid=0,mid2=0,low=Integer.MAX_VALUE,high=-1,l=0,h=0,count =0;

      for(int i=0;i<m;i++){
        low = Math.min(low,matrix[i][0]);
        high = Math.max(high,matrix[i][n-1]);
      }

      int req = m*n/2;

      while(low<=high){
        mid = low+(high-low)/2;
        count=0;

        for(int i=0;i<m;i++){
            l=0;h=n-1;
            while(l<=h){
                mid2=l+(h-l)/2;
                if(matrix[i][mid2]<=mid) l=mid2+1;
                else h=mid2-1;
            }
            count+=l;
        }
        if(count<=req) low=mid+1;
        else high = mid-1;
      }
      return low;
    }
}
