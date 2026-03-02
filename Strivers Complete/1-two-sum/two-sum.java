class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int key = 0;

        for(int i=0;i<nums.length;i++){
            key = target - nums[i];
            if(!map.containsKey(key)) map.put(nums[i],i);
            else return new int[]{map.get(key),i};
        }
        return new int[]{-1,-1};
    }
}