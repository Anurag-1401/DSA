class Solution {
    public int mySqrt(int x) {
        if (x < 2) { return x; }  

        int left = 1;
        int right = x/2 + 1;

        while (left < right) {
            int mid = left + (right - left + 1)/2;
            long midSquare = (long) mid * mid;

            if (midSquare <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
