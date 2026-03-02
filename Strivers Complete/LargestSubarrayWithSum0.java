class Solution {
    public int maxLen(int[] arr) {
        int length =0,maxL=0,sum=0;

        for(int i=0,j=0;i<arr.length;i++){
            sum+=arr[i];

            while(sum>0 && j<=i){
                sum-=arr[j++];
            }

            if(sum == 0) maxL = Math.max(maxL,i-j+1);
        }
        return maxL;
    }
}
