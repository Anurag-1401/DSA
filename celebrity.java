class Solution {
    public int celebrity(int[][] M) {
      int n = M.length,top = -1;
      int[] st = new int[n];

      for(int i=0;i<n;i++) st[++top] = i;

      while(top > 1){
        int a = st[top--];
        int b = st[top--];

        if(M[a][b] == 1) st[++top] = b;
        else st[++top] = a;
      }

      int cel = st[top];

      for(int i=0;i<n;i++){
        if(i!=cel){
            if(M[cel][i] == 1 || M[i][cel] == 0) return -1;
        }
      }
      return cel;
    }
}
