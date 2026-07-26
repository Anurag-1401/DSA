class Solution {
    public int trap(int[] height) {
        int lptr = 0, rptr = height.length - 1;
        int lmax = 0, rmax = 0;
        int area = 0;
        while(lptr < rptr){
            lmax = Math.max(lmax, height[lptr]);
            rmax = Math.max(rmax, height[rptr]);
            if(lmax < rmax){
                area += (lmax - height[lptr]);
                lptr++;
            }else{
                area += (rmax - height[rptr]);
                rptr--;
            }
        }
        return area;
    }
}
