class Solution {
    public int kthElement(int[] nums1, int[] nums2, int l) {
      int m=nums1.length,n=nums2.length,i=0,j=0,k=0;
        int[] ans = new int[m+n];

        while(i<m && j<n){
            if(nums1[i]<nums2[j]) ans[k++] = nums1[i++];
            else ans[k++] = nums2[j++];
        }

        while(i<m) ans[k++] = nums1[i++];
        while(j<n) ans[k++] = nums2[j++];

        return ans[l-1];
    }
}
