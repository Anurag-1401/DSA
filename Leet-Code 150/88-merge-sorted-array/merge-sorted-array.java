class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            System.out.println(nums1);
        } else if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            System.out.println(nums1);
        } else {
            int index = 1;
            for (int i = nums1.length - 1; i > nums1.length - nums2.length - 1; i--) {
                nums1[i] = nums2[n - index++];
            }
            Arrays.sort(nums1);
            System.out.println(nums1);
        }

    }
}