class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length,idx = 0,top=-1;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);

        int[] stack = new int[2*n];

        for(int i=0;i<2*n;i++){
            idx = i%n;
            while(top>=0 && nums[stack[top]] < nums[idx]){
                ans[stack[top--]] = nums[idx];
            }
            if(i<n) stack[++top] = idx;
        }
        return ans;
    }
}