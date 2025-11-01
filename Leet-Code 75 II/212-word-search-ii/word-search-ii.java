class Solution {
    class Trie{
        Trie[] children = new Trie[26];
        String word;
    }

    private Trie build(String[] words){
        Trie root = new Trie();

        for(String w:words){
            Trie node = root;
            for(char c : w.toCharArray()){
                int i = c-'a';
                if(node.children[i] == null) node.children[i] = new Trie();
                node = node.children[i];
            }
            node.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie root = build(words);

        int row = board.length, col = board[0].length;
        for(int r = 0;r<row;r++){
            for(int c=0;c<col;c++){
                dfs(board,r,c,root,res);
            }
        }
        return res;
    }

    private void dfs(char[][] board,int r,int c,Trie node,List<String> res){
        if(r<0 || c<0 || r >=board.length || c >= board[0].length) return;
        
        char ch = board[r][c];
        if(ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch-'a'];
        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';
        dfs(board,r+1,c,node,res);
        dfs(board,r-1,c,node,res);
        dfs(board,r,c+1,node,res);
        dfs(board,r,c-1,node,res);
        board[r][c] = ch;
    }
}