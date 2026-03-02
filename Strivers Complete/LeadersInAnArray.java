class Solution {
    public List<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        int max = nums[nums.length-1];
        ans.add(max);

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
