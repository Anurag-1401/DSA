class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];

        boolean[] cols = new boolean[n];
        boolean[] dia1 = new boolean[2*n-1];
        boolean[] dia2 = new boolean[2*n-1];

        check(0,cols,dia1,dia2,count,n);
        return count[0];
    }

    private void check(int i,boolean[] cols,boolean[] dia1,boolean[] dia2,
        int[] c,int n){
            if(i==n){
                c[0]++;
                return;
            }

            for(int j=0;j<n;j++){
                if(cols[j] || dia1[i+j] || dia2[i-j+n-1]) continue;

                cols[j] = true;
                dia1[i+j] = true;
                dia2[i-j+n-1] = true;

                check(i+1,cols,dia1,dia2,c,n);

                cols[j] = false;
                dia1[i+j] = false;
                dia2[i-j+n-1] = false;
            }
        }
}
