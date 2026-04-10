class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        
        // int prev = 1,prev1 = 2;

        // for(int i=3;i<=n;i++){
        //     int curr = prev+prev1; 
        //     prev = prev1;
        //     prev1 = curr;
        // }
        // return prev1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
