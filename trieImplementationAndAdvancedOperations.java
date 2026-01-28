class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public int countWordsEqualTo(String word) {
        return root.countWordsEqualTo(word, 0);
    }

    public int countWordsStartingWith(String prefix) {
        return root.countWordsStartingWith(prefix, 0);
    }

    public void erase(String word) {
        root.erase(word, 0);
    }
}

class Node {
    Node[] nodes;
    int cntEnd;
    int cntPrefix;

    public Node() {
        nodes = new Node[26];
        cntEnd = 0;
        cntPrefix = 0;
    }

    public void insert(String word, int index) {
        if (index == word.length()) {
            cntEnd++;
            return;
        }

        int idx = word.charAt(index) - 'a';
        if (nodes[idx] == null) {
            nodes[idx] = new Node();
        }

        nodes[idx].cntPrefix++;
        nodes[idx].insert(word, index + 1);
    }

    public int countWordsEqualTo(String word, int index) {
        if (index == word.length()) {
            return cntEnd;
        }

        int idx = word.charAt(index) - 'a';
        if (nodes[idx] == null) {
            return 0;
        }

        return nodes[idx].countWordsEqualTo(word, index + 1);
    }

    public int countWordsStartingWith(String prefix, int index) {
        if (index == prefix.length()) {
            return cntPrefix;
        }

        int idx = prefix.charAt(index) - 'a';
        if (nodes[idx] == null) {
            return 0;
        }

        return nodes[idx].countWordsStartingWith(prefix, index + 1);
    }

    public void erase(String word, int index) {
        if (index == word.length()) {
            cntEnd--;
            return;
        }

        int idx = word.charAt(index) - 'a';
        Node child = nodes[idx];
        child.cntPrefix--;
        child.erase(word, index + 1);
    }
}
