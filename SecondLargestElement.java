class Solution {
    public int secondLargestElement(int[] nums) {
        int lar = Integer.MIN_VALUE,seclar = Integer.MIN_VALUE;

        for(int a:nums){
            if(a>lar) {
                seclar = lar;
                lar = a;
            } else if(a<lar && a>seclar){
                seclar = a;
            }
        }

        if(seclar == Integer.MIN_VALUE) return -1;
        
        return seclar;
    }
}
