class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length,cols = board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(visit(0,r,c,word,board)) return true;
            }
        }
        return false;
    }

    private boolean visit(int i,int r,int c,String word,char[][] b){
        if(i==word.length()) return true;

        if(c<0 || r<0 || c>=b[0].length || r>=b.length || word.charAt(i) != b[r][c]) return false;

        char ch = b[r][c];

        b[r][c] ='#';

        boolean found = 
            visit(i+1,r+1,c,word,b) ||
            visit(i+1,r-1,c,word,b) ||
            visit(i+1,r,c+1,word,b) ||
            visit(i+1,r,c-1,word,b);

        b[r][c] = ch;

        return found;
    }
}