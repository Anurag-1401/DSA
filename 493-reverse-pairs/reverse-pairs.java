class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1, i = 0;
        int[] result = new int[high - low + 1];

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) result[i++] = arr[left++];
            else result[i++] = arr[right++];
        }
        while (left <= mid) result[i++] = arr[left++];
        while (right <= high) result[i++] = arr[right++];

        for (int j = 0; j < result.length; ++j)
            arr[low + j] = result[j];
    }

    public int countPairs(int[] arr, int low, int mid, int high) {
        int cnt = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; ++i) {
            while (right <= high && (long)arr[i] > 2L * arr[right]) right++;
            cnt += right - (mid + 1);
        }
        return cnt;
    }

    public int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int cnt = 0;
        cnt += mergeSort(arr, left, mid);
        cnt += mergeSort(arr, mid + 1, right);
        cnt += countPairs(arr, left, mid, right);
        merge(arr, left, mid, right);

        return cnt;
    }
}
