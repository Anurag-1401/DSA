class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){
            reverse(nums,0,n-1);
            return;
        }

        for(int i=n-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                swap(nums,i,pivot);
                break;
            }
        }

        reverse(nums,pivot+1,n-1);
    }

    private void swap(int[] a,int i,int j){
        int t = a[i];
        a[i]=a[j];
        a[j]=t;

    }

    private void reverse(int[] a,int i,int j){
        while(i<j){
            swap(a,i,j);
            i++;j--;
        }
    }
}