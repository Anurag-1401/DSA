class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int i=0,j=0;

        while(i< nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;j++;
            } else if(nums1[i]<nums2[j]){
                ans.add(nums1[i++]);
            } else {
                ans.add(nums2[j++]);
            }
        }

        while(i<nums1.length) ans.add(nums1[i++]);
        while(j<nums2.length) ans.add(nums2[j++]);

        return ans.stream().mapToInt(k->k).toArray();
    }
}
