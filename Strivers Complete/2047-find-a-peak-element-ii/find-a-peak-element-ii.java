class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length,n=mat[0].length,low=0,high=n-1,maxRow=0,l=0,r=0,mid=0;

        while(low<=high){
            mid = low+(high-low)/2;

            maxRow = 0;
            for(int i=0;i<m;i++){
                if(mat[i][mid]>mat[maxRow][mid]) maxRow = i;
            }

            l = (mid-1 >=0) ? mat[maxRow][mid-1]: -1;
            r= (mid+1 <n) ? mat[maxRow][mid+1]:-1;

            if(mat[maxRow][mid]>l && mat[maxRow][mid]>r) return new int[]{maxRow,mid};
            else if(l>mat[maxRow][mid]) high = mid-1;
            else low = mid+1;
        }
        return new int[]{-1,-1};
    }
}