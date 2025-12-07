class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length;
        int[] merge = new int[m+n];

        int i=0,j=0,k=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]) merge[k++] = nums1[i++];
            else merge[k++] = nums2[j++];
        }

        while(i<m) merge[k++] = nums1[i++];
        while(j<n) merge[k++] = nums2[j++];

        int len = merge.length;
        if(len%2==1) return merge[len/2];
        else return (merge[len/2-1] + merge[len/2]) / 2.0;
    }
}