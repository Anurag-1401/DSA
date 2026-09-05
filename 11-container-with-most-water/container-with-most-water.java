class Solution {
    public int maxArea(int[] height) {
        int l =0,r=height.length-1,max = 0,min=0;

        while(l<r){
            int wd = r-l;
            if(height[l]<height[r]) min = height[l++];
            else min = height[r--];
            max = Math.max(max,wd*min);
        }

        return max;
    }
}