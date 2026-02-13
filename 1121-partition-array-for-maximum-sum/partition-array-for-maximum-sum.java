class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        // tabulation
        int[] tab = new int[n+1];

        for(int index = n-1; index >= 0; index--){
            if(index+k >= n){
                int maxEle = 0;
            
                for(int i = index; i < n; i++)
                    maxEle = Math.max(maxEle, arr[i]);

                tab[index] = (n-index)*maxEle;
            } else {
                int currMax = 0;
                int limit = index+k;
                int ans = 0;

                for(int mid = index; mid < limit; mid++){
                    currMax = Math.max(currMax, arr[mid]);
                    int tempAns = ((mid-index+1)*currMax) + tab[mid+1];
                    ans = Math.max(ans, tempAns);
                }

                tab[index] = ans;
            }
        }

        return tab[0];
    }
}