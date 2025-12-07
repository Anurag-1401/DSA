class LFUCache {
    private final int capacity;

    private final SingleNode sortedFrequenciesHead;

    private final Node keyMap[];
    private int numberOfKeys;

    private class SingleNode {
        final int frequency;

        final Node mruHead;
        final Node mruTail;

        SingleNode next;

        public SingleNode(final int frequency, final Node mruHead, final Node mruTail) {
            this.frequency = frequency;

            this.mruHead = mruHead;
            this.mruTail = mruTail;

            this.next = null;
        }
    }

    private class Node {
        final int key;
        int value;

        Node previous;
        Node next;

        int frequency;

        public Node(final int key, final int value) {
            this.key = key;
            this.value = value;

            this.previous = null;
            this.next = null;

            this.frequency = 0;
        }
    }

    public LFUCache(final int capacity) {
        this.capacity = capacity;

        this.sortedFrequenciesHead = new SingleNode(0, null, null);

        final SingleNode maxFrequenciesTail = new SingleNode(Integer.MAX_VALUE, null, null);
        this.sortedFrequenciesHead.next = maxFrequenciesTail;

        this.keyMap = new Node[100001];
        this.numberOfKeys = 0;
    }
    
    public int get(final int key) {
        final Node node = this.keyMap[key];

        if (node == null) {
            return -1;
        }

        increaseFrequency(node);
        return node.value;
    }

    public void put(final int key, final int value) {
        final Node node = this.keyMap[key];

        if (node != null) {
            node.value = value;
            increaseFrequency(node);
        } else {
            if (this.numberOfKeys >= this.capacity) {
                evictLfu();
            }

            final Node newNode = new Node(key, value);
            increaseFrequency(newNode);
            this.keyMap[key] = newNode;
            this.numberOfKeys++;
        }
    }

    private void increaseFrequency(final Node node) {
        node.frequency++;

        SingleNode previousToPreviousNode = null;
        SingleNode previousNode = this.sortedFrequenciesHead;

        while (previousNode.next != null) {
            if (node.frequency <= previousNode.next.frequency) {
                break;
            }

            previousToPreviousNode = previousNode;
            previousNode = previousNode.next;
        }

        final SingleNode nextNode = previousNode.next;
        final SingleNode frequencyNode;

        if (node.frequency == nextNode.frequency) {
            frequencyNode = nextNode;
        } else {
            // Create a new LRU linked list and then insert a new frequency node
            final Node mruHead = new Node(-1, -1);
            final Node mruTail = new Node(-1, -1);

            mruHead.next = mruTail;
            mruTail.previous = mruHead;

            frequencyNode = new SingleNode(node.frequency, mruHead, mruTail);
            frequencyNode.next = nextNode;
            previousNode.next = frequencyNode; 
        }

        if (node.frequency > 1) {
            removeNode(node);

            // Is this linked list empty?
            if (previousNode.mruTail.previous.key == -1) {
                previousToPreviousNode.next = frequencyNode;
            }
        }

        addNode(frequencyNode.mruHead, node);
    }

    private void evictLfu() {
        final SingleNode lowestFrequencyNode = this.sortedFrequenciesHead.next;

        final Node mruTail = lowestFrequencyNode.mruTail;
        final Node nodeToEvict = mruTail.previous;

        removeNode(nodeToEvict);

        this.keyMap[nodeToEvict.key] = null;
        this.numberOfKeys--;

        // Is this linked list empty?
        if (mruTail.previous.key == -1) {
            this.sortedFrequenciesHead.next = lowestFrequencyNode.next;
        }
    }

    private void removeNode(final Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void addNode(final Node mruHeadNode, final Node node) {
        node.next = mruHeadNode.next;
        node.previous = mruHeadNode;

        mruHeadNode.next = node;
        node.next.previous = node;
    }
}