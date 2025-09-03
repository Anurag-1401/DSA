class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> pair = new HashMap<>();
        int num = 0;

        for(int i=0;i<nums.length;i++){
            num = target - nums[i];
            if(pair.containsKey(num)) return new int[]{pair.get(num),i};
            pair.put(nums[i],i);
        }
        return new int[]{};
    }
}