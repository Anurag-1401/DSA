class Solution {
    public int countSquares(int[][] mat) {
        int r=mat.length,c=mat[0].length;
        int dp[][]=new int[r][c];
        for(int j=0;j<c;j++){
            if(mat[r-1][j]==1) dp[r-1][j]=1;
        }
        for(int i=0;i<r;i++){
            if(mat[i][c-1]==1) dp[i][c-1]=1;
        }

        for(int i=r-2;i>=0;i--){
            for(int j=c-2;j>=0;j--){
                if(mat[i][j]==1){
                    dp[i][j]=1+min(dp[i+1][j],dp[i][j+1],dp[i+1][j+1]);
                }
            }
        }
        int ans=0;
        for(int y[]:dp){
            for(int ele:y) ans+=ele;
        }
        return ans;
    }

    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}