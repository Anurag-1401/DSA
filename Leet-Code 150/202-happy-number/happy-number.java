import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int totalSum = 0;
            while (n > 0) {
                int digit = n % 10;
                totalSum += digit * digit;
                n /= 10;
            }
            n = totalSum;
        }
        return n == 1;
    }
}
