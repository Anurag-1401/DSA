class Solution {
    public int minCost(int stickLength, int[] cutPositions) {
        int numberOfCuts = cutPositions.length;
        Arrays.sort(cutPositions); 

        int[] allCuts = new int[numberOfCuts + 2];
        allCuts[0] = 0;

        for (int index = 0; index < numberOfCuts; index++) {
            allCuts[index + 1] = cutPositions[index];
        }

        allCuts[numberOfCuts + 1] = stickLength;
 
        int[][] dp = new int[numberOfCuts + 2][numberOfCuts + 2];
        
        for (int segmentSize = 2; segmentSize < numberOfCuts + 2; segmentSize++) {
            for (int start = 0; start + segmentSize < numberOfCuts + 2; start++) {

                int end = start + segmentSize;
                dp[start][end] = Integer.MAX_VALUE;
                
                for (int mid = start + 1; mid < end; mid++) {
                    dp[start][end] = Math.min(
                        dp[start][end],
                        dp[start][mid] + dp[mid][end]
                    );
                }
                dp[start][end] += allCuts[end] - allCuts[start];
            }
        }
        return dp[0][numberOfCuts + 1];
    }
}