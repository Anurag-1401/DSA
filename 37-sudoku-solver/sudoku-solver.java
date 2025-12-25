class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowHas = new boolean[9][9];
        boolean[][] colHas = new boolean[9][9];
        boolean[][][] subBoxHas = new boolean[3][3][9];

        List<int[]> emptyPos = new ArrayList<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    emptyPos.add(new int[]{i,j});
                } else{
                    int x = board[i][j] - '1';
                    rowHas[i][x] = colHas[j][x] = subBoxHas[i/3][j/3][x] = true;
                }
            }
        }

        PriorityQueue<int[]> emptyPQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] pos:emptyPos){
            int i = pos[0];
            int j=pos[1];
            int cand = getCand(i,j,rowHas,colHas,subBoxHas);
            emptyPQ.offer(new int[]{cand,i,j});
        }

        dfs(board,rowHas,colHas,subBoxHas,emptyPQ);
    }

    private int getCand(int i,int j,boolean[][] rowHas,boolean[][] colHas,boolean[][][] subBoxHas){
        int cand = 9;
        for(int x = 0;x<9;x++){
            if(rowHas[i][x]|| colHas[j][x] || subBoxHas[i/3][j/3][x]) cand--;
        }
        return cand;
    }

    private boolean dfs(char[][] board,boolean[][] rowHas,boolean[][] colHas,boolean[][][] subBoxHas,PriorityQueue<int[]> emptyPQ ){
        if(emptyPQ.isEmpty()) return true;

        int[] top = emptyPQ.poll();
        int i = top[1],j=top[2];

        int cand = 0;
        for(int x = 0;x<9;x++){
            if(rowHas[i][x]|| colHas[j][x] || subBoxHas[i/3][j/3][x]) continue;

            board[i][j] = (char)('1'+x);
            rowHas[i][x] = colHas[j][x] = subBoxHas[i/3][j/3][x] = true;

            if(dfs(board,rowHas,colHas,subBoxHas,emptyPQ)) return true;
            rowHas[i][x] = colHas[j][x] = subBoxHas[i/3][j/3][x] = false;

            cand++;
        }

        emptyPQ.offer(new int[]{cand,i,j});
        return false;
    }
}