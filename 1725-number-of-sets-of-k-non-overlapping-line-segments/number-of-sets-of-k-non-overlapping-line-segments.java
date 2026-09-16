class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        long totalPoints = n + k - 1;
        long slotsToChoose = 2 * k;

        if (totalPoints < slotsToChoose) {
            return 0;
        }

        return (int) nCr(totalPoints, slotsToChoose);
    }

    private long nCr(long n, long r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n / 2) r = n - r;

        long num = 1;
        long den = 1;

        for (int i = 1; i <= r; i++) {
            num = (num * (n - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (num * modInverse(den, MOD)) % MOD;
    }

    private long modInverse(long a, int m) {
        return power(a, m - 2, m);
    }

    private long power(long x, long y, int m) {
        long res = 1;
        x = x % m;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % m;
            y >>= 1;
            x = (x * x) % m;
        }
        return res;
    }
}