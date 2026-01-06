class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;

        if (windowSize == 0) {
            int total = 0;
            for (int x : cardPoints) total += x;
            return total;
        }

        int totalSum = 0;
        for (int x : cardPoints) totalSum += x;

        int currSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currSum += cardPoints[i];
        }

        int minWindowSum = currSum;

        for (int right = windowSize; right < n; right++) {
            currSum += cardPoints[right];
            currSum -= cardPoints[right - windowSize];
            if (currSum < minWindowSum) {
                minWindowSum = currSum;
            }
        }

        return totalSum - minWindowSum;
    }
}
