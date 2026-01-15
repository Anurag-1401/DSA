class Solution {
    public long solve(int[] bt) {
        int n = bt.length;

        Arrays.sort(bt);

        int totalWT = 0;
        int currT = 0;

        for(int b : bt){
            totalWT+=currT;
            currT+=b;
        }

        return totalWT/n;
    }
}
