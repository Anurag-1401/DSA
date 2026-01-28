class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }
    }

    public String completeString(List<String> nums) {
        Trie trie = new Trie();

        for (String word : nums) {
            trie.insert(word);
        }

        String ans = "";

        for (String word : nums) {
            if (isComplete(word, trie.root)) {
                if (word.length() > ans.length() ||
                   (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }

        return ans.length() == 0 ? "None" : ans;
    }

    private boolean isComplete(String word, TrieNode root) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            node = node.children[idx];
            if (node == null || !node.isEnd) {
                return false;
            }
        }
        return true;
    }
}
