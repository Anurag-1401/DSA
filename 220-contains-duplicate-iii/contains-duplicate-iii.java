 class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        HashMap<Integer, Integer> bucketMap = new HashMap<>();
        int bucketSize = valueDiff + 1;
        int offset = Integer.MAX_VALUE;

        for (int i : nums) offset = Math.min(offset, i);

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int bucketKey = (num - offset) / bucketSize;

            if (bucketMap.containsKey(bucketKey)) return true;
            if (bucketMap.containsKey(bucketKey - 1)
                    && Math.abs(nums[i] - bucketMap.get(bucketKey - 1)) <= valueDiff) return true;
                    
            if (bucketMap.containsKey(bucketKey + 1)
                    && Math.abs(nums[i] - bucketMap.get(bucketKey + 1)) <= valueDiff) return true;

            bucketMap.put(bucketKey, nums[i]);
            if (i >= indexDiff) {
                bucketMap.remove(((nums[i - indexDiff]) - offset) / bucketSize);
            }
        }
        return false;
    }
}