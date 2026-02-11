class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }

        return findRes(word1, word2, dp, n-1,m-1);
    }

    public int findRes(String s1, String s2, int[][] dp, int i, int j ){
        
        if(i < 0){
            return j + 1;
        }
        if(j < 0){
            return i + 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = findRes(s1, s2, dp, i-1, j-1);
        }
        else {
            return dp[i][j] = 1 + Math.min(findRes(s1,s2,dp,i,j-1),Math.min(findRes(s1, s2, dp, i-1, j), findRes(s1, s2, dp, i-1,j-1))); 
        }
    }
}