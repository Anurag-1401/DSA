class Solution {
    public double myPow(double x, long n) {
        if (n == 0) return 1;

        if (n < 0) return 1 / myPow(x, -n);

        double half = myPow(x, n / 2);

        if (n % 2 == 0) 
            return half * half;

        return half * half * x;
    }
}





class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= x;
            }

            x *= x;
            exp >>= 1;
        }

        return result;
    }
}
