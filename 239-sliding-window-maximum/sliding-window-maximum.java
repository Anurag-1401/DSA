class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1],dq = new int[n];
        int f = 0,r=-1,res = 0;

        for(int i=0;i<n;i++){
            if(f<=r && dq[f]<=i-k) f++;

            while(f<=r && nums[dq[r]] <= nums[i]) r--;

            dq[++r] = i;

            if(i>= k-1) ans[res++] = nums[dq[f]];
        }

        return ans;
    }
}