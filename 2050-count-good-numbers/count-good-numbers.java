class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;  // indices: 0,2,4,... → 5 choices
        long oddPositions  = n / 2;        // indices: 1,3,5,... → 4 choices
        
        long pow5 = power(5, evenPositions);
        long pow4 = power(4, oddPositions);

        return (int)((pow5 * pow4) % MOD);
    }

    // Recursive fast exponentiation
    private long power(long x, long n) {
        if (n == 0) return 1;

        long half = power(x, n / 2);

        long result = (half * half) % MOD;

        if (n % 2 == 1) 
            result = (result * x) % MOD;

        return result;
    }
}
