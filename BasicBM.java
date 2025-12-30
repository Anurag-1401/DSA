class Solution {
    public int countSetBits(int n) {
        int c=0;
        while(n!=0){
            n&=(n-1);
            c++;
        }
        return c;
    }
}




class Solution {
    public boolean checkIthBit(int n, int i) {
        return (n & (1<<i)) != 0;
    }
}





class Solution {
    public boolean isOdd(int n) {
        return (n&1)==1;
    }
}





class Solution {
    public int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        return new int[]{a,b};
    }
}






class Solution {
    public int findRangeXOR(int l, int r) {
        int res = 0;

        for(int i=l;i<r+1;i++){
            res^=i;
        }
        return res;
    }
}
