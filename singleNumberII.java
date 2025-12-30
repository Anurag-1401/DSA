class Solution {    
    public int[] singleNumber(int[] nums) {        
        int xor = 0;
        for(int n:nums){
            xor^=n;
        }

        int diff = xor & (-xor);

        int a = 0,b = 0;
        for(int n:nums){
            if((n&diff)==0) a^=n;
            else b^=n; 
        }

        if(a<b) return new int[]{a,b};
        return new int[]{b,a};
    }
}
