class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long num = n - 1;

        int bit = 0;

        while (num > 0) {
            if ((x & (1L << bit)) == 0) {
                if ((num & 1) == 1) {
                    ans |= (1L << bit);
                }
                num >>= 1;
            }
            bit++;
        }

        return ans;
    }
}
