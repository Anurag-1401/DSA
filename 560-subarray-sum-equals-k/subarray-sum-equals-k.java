class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum=0,count=0,rem=0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            rem = preSum - k;
            if(map.containsKey(rem)) count+=map.get(rem);

            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}