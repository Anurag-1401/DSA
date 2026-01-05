class LRUCache {

    int cap,size;

    int[] key,value,map,prev,next;

    int head,tail,i;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;

        key = new int[capacity];
        value = new int[capacity];
        prev = new int[capacity];
        next = new int[capacity];

        head = -1;
        tail = -1;

        map = new int[10001];
        Arrays.fill(map,-1);
    }
    
    public int get(int k) {
        int node = map[k];
        if (node == -1) return -1;

        moveToFront(node);
        return value[node];
    }
    
    public void put(int k, int v) {
        if (map[k] != -1) {
            int node = map[k];
            value[node] = v;
            moveToFront(node);
            return;
        }

        int node;

        if (size == cap) {
            node = tail;
            map[key[node]] = -1;
            removeNode(node);
            size--;
        } else {
            node = size;
        }

        key[node] = k;
        value[node] = v;
        map[k] = node;

        addToFront(node);
        size++;
    }

    private void moveToFront(int node) {
        if (node == head) return;
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(int node) {
        int p = prev[node];
        int n = next[node];

        if (p != -1) next[p] = n;
        else head = n;

        if (n != -1) prev[n] = p;
        else tail = p;
    }

    private void addToFront(int node) {
        prev[node] = -1;
        next[node] = head;

        if (head != -1) prev[head] = node;
        head = node;

        if (tail == -1) tail = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */