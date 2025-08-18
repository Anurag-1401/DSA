import java.util.*;

class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail (to avoid null checks)
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        // Move this node to the front (most recently used)
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Remove the old node
            remove(map.get(key));
        } else if (map.size() == capacity) {
            // Remove the least recently used node (from tail)
            remove(tail.prev);
        }

        // Insert new node at front
        Node newNode = new Node(key, value);
        insertToFront(newNode);
    }

    // Helper: remove a node from DLL
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: insert a node right after head
    private void insertToFront(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
