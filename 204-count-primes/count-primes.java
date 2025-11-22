class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0; // no primes less than 2

        boolean[] isComposite = new boolean[n]; // false = prime, true = not prime
        int count = n / 2; // start by assuming half of numbers are odd → possible primes

        // We skip even numbers to save time
        for (int i = 3; i * i < n; i += 2) {
            if (!isComposite[i]) {
                // mark odd multiples of i as composite
                for (int j = i * i; j < n; j += 2 * i) {
                    if (!isComposite[j]) {
                        isComposite[j] = true;
                        count--;
                    }
                }
            }
        }

        return count;
    }
}