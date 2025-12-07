class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,curr=0;

        for(int num : nums){
            if(num == 1) {
                curr++;
                if(curr>max) max = curr;
            } else curr = 0;
        }
        return max;
    }
}