class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length, l=0,r=m*n-1,val=0,mid=0;

        while(l<=r){
            mid=l+(r-l)/2;

            val = matrix[mid/n][mid%n];
            if(val == target) return true;
            else if(val<target) l=mid+1;
            else r=mid-1;
        }
        return false;
    }
}