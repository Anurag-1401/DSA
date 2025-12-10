class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private int mergeSort(int[] nums,int l,int r){
        if(l>=r) return 0;
        
        int count = 0;
        int mid = l+(r-l)/2;

        count+=mergeSort(nums,l,mid);
        count+=mergeSort(nums,mid+1,r);
        count+=merge(nums,l,mid,r);

        return count;
    }

    private int merge(int[] nums,int l,int mid,int r){
        int[] temp = new int[r-l+1];
        int j=mid+1,k=0,count=0;

        for(int i=l;i<=mid;i++){
            while(j<=r && (long)nums[i] > 2L * nums[j]) j++;
            count+=(j-mid-1);
        }

        int i=l;
        j=mid+1;
        while(i<=mid && j<=r){
            if(nums[i]<=nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while(i<=mid) temp[k++] = nums[i++];
        while(j<=r) temp[k++] = nums[j++];

        for(int x=0;x<temp.length;x++) nums[l+x] = temp[x];

        return count;
    }
}