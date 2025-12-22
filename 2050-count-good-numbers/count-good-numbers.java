class Solution {
    final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long countEven = (n+1)/2;
        long countOdd = n/2;

        long pow5 = power(5,countEven);
        long pow4 = power(4,countOdd);

        return (int)((pow5*pow4)%MOD);
    }

    private long power(int x,long y){
        if(y==0) return 1;

        long half = power(x,y/2);

        long res = (half*half)%MOD;

        if(y%2==1) return (res*x)%MOD;

        return res;
    }
}