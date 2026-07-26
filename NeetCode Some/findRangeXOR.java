class Solution {
    public int findRangeXOR(int l, int r) {
        return find(l-1) ^ find(r);
    }

    private int find(int n){
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n+1;
        if(n % 4 ==3) return 0;
        return n;
    }
}
