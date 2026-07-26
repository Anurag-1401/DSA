/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return cloneNode(node, new HashMap<>());
    }

    private Node cloneNode(Node original, Map<Node, Node> visited) {
        if (original == null) return null;

        if (visited.containsKey(original)) {
            return visited.get(original);
        }

        Node copy = new Node(original.val);
        visited.put(original, copy);

        for (Node neighbor : original.neighbors) {
            copy.neighbors.add(cloneNode(neighbor, visited));
        }

        return copy;
    }
}
