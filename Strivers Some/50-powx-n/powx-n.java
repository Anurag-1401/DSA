class Solution {
    public double myPow(double x, long n) {
        if (n == 0) return 1;

        // Handle negative exponent
        if (n < 0) return 1 / myPow(x, -n);

        // Recursive step
        double half = myPow(x, n / 2);

        // If exponent is even
        if (n % 2 == 0) 
            return half * half;

        // If exponent is odd
        return half * half * x;
    }
}