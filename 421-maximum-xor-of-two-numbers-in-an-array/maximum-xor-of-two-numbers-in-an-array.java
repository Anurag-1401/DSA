class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null) {
                    node.child[bit] = new TrieNode();
                }
                node = node.child[bit];
            }
        }

        int getMaxXor(int num) {
            TrieNode node = root;
            int maxXor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = 1 - bit;

                if (node.child[opposite] != null) {
                    maxXor |= (1 << i);
                    node = node.child[opposite];
                } else {
                    node = node.child[bit];
                }
            }
            return maxXor;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int max = 0;

        trie.insert(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, trie.getMaxXor(nums[i]));
            trie.insert(nums[i]);
        }
        return max;
    }
}
