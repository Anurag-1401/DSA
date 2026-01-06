class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l=0,oC=0,eC=0,res=0;

        for(int r=0;r<nums.length;r++){
            if(nums[r] % 2!= 0){
                oC++;
                eC=0;
            }

            while(oC == k){
                eC++;
                if(nums[l] % 2!=0) oC--;
                l++;
            }

            res+=eC;
        }
        return res;
    }
}