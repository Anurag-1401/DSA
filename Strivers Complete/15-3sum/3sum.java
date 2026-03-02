class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left=0,right=0,target=0;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]== nums[i-1]) continue;

            left = i+1;
            right=nums.length-1;

            while(left<right){
                target = nums[i]+nums[left]+nums[right];
                if(target == 0) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                    while(left<right && nums[left-1] == nums[left]) left++;
                    while(right>=0 && nums[right+1] == nums[right]) right--;
                }  else if(target<0) left++;
                else right--;
            }
        }
        return res;
    }
}