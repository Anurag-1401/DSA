class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int length = 0,maxL=0,curr=0;

        HashSet<Integer> set = new HashSet<>();

        for(int num:nums) set.add(num);

        for(int num:set){
            if(!set.contains(num-1)){
                curr = num;
                length = 1;

                while(set.contains(curr+1)){
                    length++;
                    curr++;
                }
                maxL = Math.max(length,maxL);
            }
        }
        return maxL;
    }
}