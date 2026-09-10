class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int s = s3.length();
        if(n+m!=s) return false;
        Boolean[][] dp = new Boolean[n+1][m+1];
        return memo(n,m,s1,s2,s3,dp);
    }
    public boolean memo(int i,int j,String s1,String s2,String s3,Boolean[][] dp){
        if(i==0 && j==0) return true;
        if(dp[i][j]!=null) return dp[i][j];
        boolean bool = false;
        int k = i+j;
        if(i>0 && s3.charAt(k-1)==s1.charAt(i-1)){
            bool = bool|memo(i-1,j,s1,s2,s3,dp);
        }
        if(bool) return dp[i][j] = bool;
        if(j>0 && s3.charAt(k-1)==s2.charAt(j-1)){
            bool = bool|memo(i,j-1,s1,s2,s3,dp);
        }
        return dp[i][j] = bool;
    }
}