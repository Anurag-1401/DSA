class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m=matrix[0].length,left=0,right=m*n-1,mid=0,val=0;

        while(left<=right){
            mid = (left+right) >>> 1;
            val = matrix[mid/m][mid%m];
            if(val == target) return true;
            else if(val < target) left = mid+1;
            else right=mid-1;
        }
        return false;
    }
}