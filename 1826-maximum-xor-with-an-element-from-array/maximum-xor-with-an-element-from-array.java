import java.util.*;

class Solution {

    // Binary Trie Node
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

        int maxXor(int num) {
            TrieNode node = root;
            int ans = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = 1 - bit;

                if (node.child[opposite] != null) {
                    ans |= (1 << i);
                    node = node.child[opposite];
                } else {
                    node = node.child[bit];
                }
            }
            return ans;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;
        int[][] offline = new int[q][3];

        for (int i = 0; i < q; i++) {
            offline[i][0] = queries[i][1]; // mi
            offline[i][1] = queries[i][0]; // xi
            offline[i][2] = i;             // original index
        }

        Arrays.sort(offline, Comparator.comparingInt(a -> a[0]));

        Trie trie = new Trie();
        int idx = 0;
        int[] ans = new int[q];

        for (int[] query : offline) {
            int mi = query[0];
            int xi = query[1];
            int qIndex = query[2];

            // Insert nums <= mi
            while (idx < nums.length && nums[idx] <= mi) {
                trie.insert(nums[idx]);
                idx++;
            }

            if (idx == 0) {
                ans[qIndex] = -1; // no valid numbers
            } else {
                ans[qIndex] = trie.maxXor(xi);
            }
        }

        return ans;
    }
}
