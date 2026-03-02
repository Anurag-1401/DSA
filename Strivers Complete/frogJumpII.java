class Solution {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        
        dp[0] = 0;
        
        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;
            
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int energy = dp[i - j] 
                               + Math.abs(heights[i] - heights[i - j]);
                    minEnergy = Math.min(minEnergy, energy);
                }
            }
            
            dp[i] = minEnergy;
        }
        
        return dp[n - 1];
    }
}
