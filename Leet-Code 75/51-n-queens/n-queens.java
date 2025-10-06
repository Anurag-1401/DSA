class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row:board){
            Arrays.fill(row,'.');
        }

        boolean[] cols = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];

        backtrack(0,board,cols,dia1,dia2,res,n);
        return res;
    }

    private void backtrack(int row,char[][] board,boolean[] cols,boolean[] dia1,boolean[] dia2,List<List<String>> res,int n){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }

        for(int i=0;i<n;i++){
            if(cols[i] || dia1[row+i] || dia2[row-i+n]) continue;

            board[row][i] = 'Q';
            cols[i] = true;
            dia1[row+i] = true;
            dia2[row-i+n] = true;

            backtrack(row+1,board,cols,dia1,dia2,res,n);

            board[row][i] = '.';
            cols[i] = false;
            dia1[row+i] = false;
            dia2[row-i+n] = false;
        }
    }
}