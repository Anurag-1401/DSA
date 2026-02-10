class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[202][202];
        return recur(triangle, 0, 0, dp);
    }

    public int recur(List<List<Integer>> triangle, int row, int i, Integer[][] dp){
        if(row == triangle.size()-1)
            return triangle.get(row).get(i);

        if(dp[row][i]!=null)
            return dp[row][i];
            
        return dp[row][i] = triangle.get(row).get(i) + Math.min(recur(triangle, row+1, i, dp), 
                                                        recur(triangle, row+1, i+1, dp));
    }
}