class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int len = nums.length;
        int freq[] = new int[len + 1];
        int elementCount = 0,result = 0,left = 0,mid = 0;

        for(int right = 0; right < len; right++){
            if(++freq[nums[right]] == 1) elementCount++;

            while(elementCount > k){
                if(--freq[nums[mid++]] == 0){
                    elementCount--;
                    left = mid;
                }
            }

            while(freq[nums[mid]] > 1) freq[nums[mid++]]--;

            if(elementCount == k) result += mid - left + 1;
        }
        return result;
    }
}