// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();

//         int[] dp = new int[n];

//         for(int j=0;j<n;j++){
//             dp[j] = triangle.get(n-1).get(j);
//         }

//         for(int i=n-2;i>=0;i--){
//             for(int j=0;j<=i;j++){
//                 dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
//             }
//         }
//         return dp[0];
//     }
// }

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