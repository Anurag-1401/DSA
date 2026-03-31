class Trie {
    Node root; 

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }
}

class Node {
    Node[] nodes;
    boolean isEnd;

    public Node(){
        nodes = new Node[26];
    }

    public void insert(String word, int index){
        if(index >= word.length()){
            return;
        }

        int nodeIndex = word.charAt(index) - 'a';
        if(nodes[nodeIndex] == null){
            nodes[nodeIndex]  = new Node();
        }

        if(index == word.length() - 1){
            nodes[nodeIndex].isEnd = true;
        } 

        nodes[nodeIndex].insert(word, index + 1);
    }

    public boolean search(String word, int index){
        if(index >= word.length()){
            return false;
        }

        Node node = nodes[word.charAt(index) - 'a'];
        if(node == null){
            return false;
        }

        if(index == word.length() - 1 && node.isEnd){
            return true;
        }

        return node.search(word, index + 1);
    }

    public boolean startsWith(String prefix, int index){
        if(index >= prefix.length()){
            return false;
        }

        Node node = nodes[prefix.charAt(index) - 'a'];
        if(node == null){
            return false;
        }

        if(index == prefix.length() - 1){
            return true;
        }

        return node.startsWith(prefix, index + 1);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// public class TrieNode {
//     TrieNode[] children = new TrieNode[26];
//     boolean endOfWord = false;
// }

// public class PrefixTree {
//     private TrieNode root;

//     public PrefixTree() {
//         root = new TrieNode();
//     }

//     public void insert(String word) {
//         TrieNode cur = root;
//         for (char c : word.toCharArray()) {
//             int i = c - 'a';
//             if (cur.children[i] == null) {
//                 cur.children[i] = new TrieNode();
//             }
//             cur = cur.children[i];
//         }
//         cur.endOfWord = true;
//     }

//     public boolean search(String word) {
//         TrieNode cur = root;
//         for (char c : word.toCharArray()) {
//             int i = c - 'a';
//             if (cur.children[i] == null) {
//                 return false;
//             }
//             cur = cur.children[i];
//         }
//         return cur.endOfWord;
//     }

//     public boolean startsWith(String prefix) {
//         TrieNode cur = root;
//         for (char c : prefix.toCharArray()) {
//             int i = c - 'a';
//             if (cur.children[i] == null) {
//                 return false;
//             }
//             cur = cur.children[i];
//         }
//         return true;
//     }
// }
