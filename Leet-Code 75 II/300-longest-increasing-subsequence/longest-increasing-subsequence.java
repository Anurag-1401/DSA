class Solution {
    public int lengthOfLIS(int[] nums) {
        // Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(arr.size() == 0 || arr.get(arr.size() - 1) < nums[i]) arr.add(nums[i]);
            else{
                int low = 0, high = arr.size() - 1;
                while(low <= high){
                    int mid = (low + high) /2;
                    if(arr.get(mid) >= nums[i]) high = mid - 1;
                    else low = mid + 1;
                }
                if(low < arr.size()) arr.set(low, nums[i]);
                else arr.add(nums[i]); 
            }
        }
        return arr.size();
    }
}
