class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int n:nums) xor ^= n;

        long diff = (long)xor & -(long)xor;

        int[] res = new int[2];

        for(int num:nums){
            if((num & diff) == 0) res[0]^=num;
            else res[1]^=num; 
        }
        return res;
    }
}