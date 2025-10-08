class Solution {
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1,area=0,max=0;

        while(left<right){
            area = Math.min(height[left],height[right]) * (right-left);
            max = Math.max(max,area);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }
}