class Solution {
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private int  mergeSort(int[] nums,int l,int r){
        if(l>=r) return 0;

        int mid = l+(r-l)/2;
        long count = 0;

        count+=mergeSort(nums,l,mid);
        count+=mergeSort(nums,mid+1,r);
        count+=merge(nums,l,mid,r);

        return count;
    }

    private int merge(int[] nums,int l,int m,int r){
        int[] temp = new int[r-l+1];

        int i=l,j=m+1,k=0;
        long count=0;

        while(i<=m && j<=r){
            if(nums[i]<=nums[j]) temp[k++] = nums[i++];
            else {
                temp[k++] = nums[j++];
                count+=(m-i+1);
            }
        }

        while(i<=m) temp[k++] = nums[i++];
        while(j<=r) temp[k++] = nums[j++];

        for(int x=0;x<temp.length;x++){
            nums[l+x] = temp[x];
        }
        return count;
    }
}
