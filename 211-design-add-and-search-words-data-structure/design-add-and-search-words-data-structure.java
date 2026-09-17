class WordDictionary {
          private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Try all 26 possible children
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (searchInNode(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int childIndex = c - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            return searchInNode(word, index + 1, node.children[childIndex]);
        }
    }
}
class TrieNode {
   TrieNode[] children;
   boolean isEnd;
   public TrieNode() {
        children = new TrieNode[26]; // 26 lowercase English letters
        isEnd = false;
   }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */