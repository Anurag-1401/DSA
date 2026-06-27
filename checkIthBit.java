class Solution {
    public boolean checkIthBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
