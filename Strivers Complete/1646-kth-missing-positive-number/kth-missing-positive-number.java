class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0,r=arr.length-1,missing=0,mid=0;

        while(l<=r){
            mid = l+(r-l)/2;

            missing = arr[mid] - (mid+1);
            if(missing<k) l=mid+1;
            else r=mid-1;
        }
        return l+k;
    }
}