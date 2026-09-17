import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> bucketMap = new HashMap<>();
        // Bucket size must be valueDiff + 1 to avoid division by zero when valueDiff == 0
        long bucketSize = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            long bucketId = getBucketId(num, bucketSize);

            // 1. Same bucket already has an element within valueDiff
            if (bucketMap.containsKey(bucketId)) {
                return true;
            }

            // 2. Check adjacent lower bucket
            if (bucketMap.containsKey(bucketId - 1) && Math.abs(num - bucketMap.get(bucketId - 1)) <= valueDiff) {
                return true;
            }

            // 3. Check adjacent upper bucket
            if (bucketMap.containsKey(bucketId + 1) && Math.abs(num - bucketMap.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Add current number to its bucket
            bucketMap.put(bucketId, num);

            // Maintain sliding window of size indexDiff
            if (i >= indexDiff) {
                long oldBucketId = getBucketId((long) nums[i - indexDiff], bucketSize);
                bucketMap.remove(oldBucketId);
            }
        }

        return false;
    }

    private long getBucketId(long val, long size) {
        // Handles negative numbers properly for integer division flooring
        if (val >= 0) {
            return val / size;
        } else {
            return (val + 1) / size - 1;
        }
    }
}