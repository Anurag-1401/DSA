class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] b = new char[n][n];

        for(char[] row:b){
            Arrays.fill(row,'.');
        }

        boolean[] cols = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];

        check(0,cols,dia1,dia2,res,b,n);
        return res;
    }

    private void check(int i,boolean[] cols,boolean[] dia1,boolean[] dia2,
        List<List<String>> res,char[][] b,int n){
            if(i==n){
                List<String> list = new ArrayList<>();
                for(int j=0;j<n;j++){
                    list.add(new String(b[j]));
                }
                res.add(list);
                return;
            }

            for(int j=0;j<n;j++){
                if(cols[j] || dia1[i+j] || dia2[i-j+n]) continue;

                b[i][j] = 'Q';
                cols[j] = true;
                dia1[i+j] = true;
                dia2[i-j+n] = true;

                check(i+1,cols,dia1,dia2,res,b,n);

                b[i][j] = '.';
                cols[j] = false;
                dia1[i+j] = false;
                dia2[i-j+n] = false;
            }
        }
}