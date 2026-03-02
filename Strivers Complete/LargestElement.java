class Solution {
    public int largestElement(int[] nums) {
        int lar = nums[0];
        for(int a:nums){
            if(a>lar) lar = a;
        }
        return lar;
    }
}
