class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length,left=1,right=0;
        long total = 0;

        for (int p : piles) 
            right = Math.max(right,p);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p +mid- 1)/mid;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}