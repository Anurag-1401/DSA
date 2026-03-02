class Solution {
    public int countOccurrences(int[] arr, int target) {
        int mid=0,l=0,r=arr.length-1,f=-1,last=-1;

        while(l<=r){
            mid = l+(r-l)/2;

            if(arr[mid]>=target) r=mid-1;
            else l=mid+1;

            if(arr[mid] == target) f=mid;
        }

        l=0;r=arr.length-1;

        while(l<=r){
            mid = l+(r-l)/2;

            if(arr[mid]<=target) l=mid+1;
            else r=mid-1;

            if(arr[mid] == target) last=mid;
        }

        return last - f +1;
    }
}
