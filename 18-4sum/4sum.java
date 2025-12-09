class Solution {
    public List<List<Integer>> fourSum(int[] nums, int k) {
        int left=0,right=0;
        long target=0;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i-1]== nums[i]) continue;

            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j-1] == nums[j]) continue;

                left = j+1;
                right = nums.length-1;

                while(left<right){
                    target = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if(target == k) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;

                        while(left<right && nums[left-1] == nums[left]) left++;
                        while(left<right && nums[right+1] == nums[right]) right--;
                    } else if(target < k) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}