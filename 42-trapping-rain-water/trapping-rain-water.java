class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] stack = new int[n];
        int top = -1;
        int water = 0;

        for(int i=0;i<n;i++){
            while(top >= 0 && height[i] > height[stack[top]]){
                int mid = stack[top--];

                if(top < 0) break;

                int left = stack[top];
                int dis = i - left - 1;
                int ht = Math.min(height[left],height[i])-height[mid];

                water+=dis*ht;
            }
            stack[++top] = i;
        }
        return water;
    }
}