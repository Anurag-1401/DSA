class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,maxL=0,zeroC=0;

        for(int r=0;r<nums.length;r++){
            if(nums[r] == 0) zeroC++;

            while(zeroC>k){
                if(nums[l] == 0) zeroC--;
                l++;
            }

            int curr = r-l+1;
            if(curr>maxL) maxL= curr;
        }
        return maxL;
    }
}