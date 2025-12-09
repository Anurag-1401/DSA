class Solution {
    public int longestConsecutive(int[] nums) {
       int maxLen = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int x : nums){
            set.add(x);
        }
        for(int num : set){
            if(!set.contains(num - 1)){
                int len = 1;    
                int curr = num;
                while(set.contains(curr + 1)){
                    len++;
                    curr++;
                }
            maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }
}