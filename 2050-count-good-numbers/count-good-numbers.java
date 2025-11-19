class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;   // positions with 5 choices
        long odd  = n / 2;         // positions with 4 choices

        long pow5 = powerIterative(5, even);
        long pow4 = powerIterative(4, odd);

        return (int)((pow5 * pow4) % MOD);
    }

    // ITERATIVE fast exponentiation (binary exponentiation)
    private long powerIterative(long x, long n) {
        long result = 1;
        x %= MOD;

        while (n > 0) {
            if ((n & 1) == 1) {    // if n is odd
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;     // square the base
            n >>= 1;               // n = n / 2
        }

        return result;
    }
}
