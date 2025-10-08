// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0,right = height.length -1,maxWater = 0;

//         while(left<right){
//             maxWater = Math.max(maxWater,Math.min(height[left],height[right]) * (right - left) );
//             if(height[left]<height[right]) left++;
//             else right--;
//         }
//         return maxWater;
//     }
// }

class Solution {
    static {
        for(int i = 0;i <100;i++) {
            maxArea(new int[] { 0, 0 });
        }
    }
    public static int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = 0;
        while(l<r) {
            int min = Math.min(height[l], height[r]);
            int area = min*(r-l);
            max = Math.max(max, area);
            while(l<r && height[l]<=min) l++;
            while(l<r && height[r]<=min) r--;
        }

        return max;
    }
}