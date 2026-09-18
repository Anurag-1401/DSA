class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if(nums == null  || nums.length == 0) return ans;

        for(int i = 0;i<nums.length;i++){
            int start = nums[i];

            while(i+1<nums.length && nums[i+1] == nums[i]+1) i++;

            if(start == nums[i]) ans.add(String.valueOf(nums[i]));
            else ans.add(start + "->" + nums[i]);
        }
        return ans;
    }
}