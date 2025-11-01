class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean end = false;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            int i = c-'a';
            if(node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.end = true;
    }
    
    public boolean search(String word) {
        return dfs(word,0,root);
    }
    private boolean dfs(String word,int start,TrieNode root){
        if(root == null) return false;
        if(start == word.length()) return root.end;

        char c = word.charAt(start);

        if(c == '.'){
            for(TrieNode child : root.children){
                if(child != null && dfs(word,start+1,child)) return true;
            }
            return false;
        } else {
            return dfs(word,start+1,root.children[c-'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */