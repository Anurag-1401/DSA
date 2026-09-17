class Solution {
    private static class Node {
        Node[] ch = new Node[26];
        String word;
        int kids;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();

        for (String w : words) {
            Node cur = root;
            for (char c : w.toCharArray()) {
                if (cur.ch[c - 'a'] == null) {
                    cur.ch[c - 'a'] = new Node();
                    cur.kids++;
                }
                cur = cur.ch[c - 'a'];
            }
            cur.word = w;
        }
        
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) 
                dfs(board, i, j, root, res);

        return res;
    }
    
    private void dfs(char[][] b, int i, int j, Node node, List<String> res) {
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length) return;

        char c = b[i][j];
        if (c == '#' || node.ch[c - 'a'] == null) return;

        Node nxt = node.ch[c - 'a'];

        if (nxt.word != null) {
            res.add(nxt.word);
            nxt.word = null;
        }
        
        b[i][j] = '#';
        dfs(b, i + 1, j, nxt, res);
        dfs(b, i - 1, j, nxt, res);
        dfs(b, i, j + 1, nxt, res);
        dfs(b, i, j - 1, nxt, res);
        b[i][j] = c;

        if (nxt.kids == 0 && nxt.word == null) {
            node.ch[c - 'a'] = null;
            node.kids--;
        }
    }
}