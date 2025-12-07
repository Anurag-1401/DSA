class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0,h=arr.length-1,mid=0,missing=0;

        while(l<=h){
            mid=l+(h-l)/2;
            missing = arr[mid] - (mid+1);

            if(missing < k) l = mid+1;
            else h = mid-1;
        }
        return l+k;
    }
}