class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
            freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> keyMap;
    private Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            update(node);
        } else {
            if (keyMap.size() == capacity) {
                DLL list = freqMap.get(minFreq);
                Node toRemove = list.removeLast();
                keyMap.remove(toRemove.key);
            }

            Node node = new Node(key, value);
            minFreq = 1;

            DLL list = freqMap.getOrDefault(1, new DLL());
            list.add(node);
            freqMap.put(1, list);

            keyMap.put(key, node);
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
}
