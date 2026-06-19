class Solution {
    public int kthElement(int[] a, int[] b, int k) {
      int m = a.length,n = b.length;

      if(m > n) return kthElement(b,a,k);

      
      int low = Math.max(0,k-n),high = Math.min(k,m);

      while(low<=high){
        int parX = (low + high) / 2;
        int parY  = k - parX;

        int maxLeftX = (parX == 0) ? Integer.MIN_VALUE : a[parX - 1];
        int minRightX = (parX == m) ? Integer.MAX_VALUE : a[parX];

        int maxLeftY = (parY == 0) ? Integer.MIN_VALUE : b[parY - 1];
        int minRightY = (parY == n) ? Integer.MAX_VALUE : a[parY];

        if(maxLeftX <= minRightY && maxLeftY <= minRightX){
            return Math.max(maxLeftX,maxLeftY);
        } else if(maxLeftX > maxRightY) high = parX - 1;
        else low = parX + 1;

      }
      return -1;
    }
}
