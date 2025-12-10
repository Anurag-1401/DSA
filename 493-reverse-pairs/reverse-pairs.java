class Solution {
    private int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int[] nums,int start,int end){
        if(start >= end) return 0;
        int mid = (start + end)/2;

        int count = mergeSort(nums,start,mid) + mergeSort(nums,mid+1,end);
        int j = mid + 1;
        for(int i = start; i <= mid; i++){
            while(j <= end && (long) nums[i] > 2L * nums[j]){
                j++;
            }
            count += j - (mid + 1);
        }
        merge(nums,start,mid,end);
        return count;
    }
    public void merge(int nums[],int start,int mid,int end){
        int i = start, j = mid + 1, k = start;
        while(i <= mid && j <= end){
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        for (i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}