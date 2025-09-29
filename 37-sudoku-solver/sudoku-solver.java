class Solution {
    public boolean solveSudoku(char[][] board) {
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,row,col,c)){
                            board[row][col] = c;
                            if(solveSudoku(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;

            int boxRow = 3*(row/3)+i/3;
            int boxCol = 3*(col/3)+i%3;

            if(board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}