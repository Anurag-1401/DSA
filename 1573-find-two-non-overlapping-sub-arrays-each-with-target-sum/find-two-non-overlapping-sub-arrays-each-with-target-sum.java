class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE;
        int[] minLen = new int[n];
        Arrays.fill(minLen, INF);
        
        int ans = INF;
        int currentSum = 0;
        int left = 0;
        int bestSoFar = INF;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }
            
            if (currentSum == target) {
                int currLen = right - left + 1;
                
                if (left > 0 && minLen[left - 1] != INF) {
                    ans = Math.min(ans, currLen + minLen[left - 1]);
                }
                
                bestSoFar = Math.min(bestSoFar, currLen);
            }
            
            minLen[right] = bestSoFar;
        }
        
        return ans == INF ? -1 : ans;
    }
}