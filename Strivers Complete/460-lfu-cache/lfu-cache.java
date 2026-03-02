class LFUCache {

    int cap,size;

    int[] key,value,map,prev,next,head,tail,freq;

    int minFq;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.minFq = 0;

        key = new int[capacity];
        value = new int[capacity];
        prev = new int[capacity];
        next = new int[capacity];
        freq = new int[capacity];

        head = new int[capacity + 1];
        tail = new int[capacity + 1];
        map = new int[100001];

        Arrays.fill(map,-1);
        Arrays.fill(head,-1);
        Arrays.fill(tail,-1);
    }
    
    public int get(int k) {
         int node = map[k];
        if (node == -1) return -1;

        increaseFq(node);
        return value[node];
    }
    
    public void put(int k, int v) {
        if(cap == 0) return;

        if (map[k] != -1) {
            int node = map[k];
            value[node] = v;
            increaseFq(node);
            return;
        }

        int node;

        if (size == cap) {
            node = tail[minFq];
            removeNode(node);
            map[key[node]] = -1;
            size--;
        } else {
            node = size;
        }

        key[node] = k;
        value[node] = v;
        freq[node] = 1;
        map[k] = node;

        addToFqList(node,1);
        minFq=1;
        size++;
    }

    private void increaseFq(int node) {
        int f = freq[node];
        removeNode(node);

        if (freq[node] < cap)freq[node]++;

        addToFqList(node, freq[node]);

        if (f == minFq && head[f] == -1) minFq++;
    }

    private void removeNode(int node) {
        int f = freq[node];
        int p = prev[node];
        int n = next[node];

        if (p != -1) next[p] = n;
        else head[f] = n;

        if (n != -1) prev[n] = p;
        else tail[f] = p;
    }

    private void addToFqList(int node, int f) {
        prev[node] = -1;
        next[node] = head[f];

        if (head[f] != -1) prev[head[f]] = node;
        head[f] = node;

        if (tail[f] == -1) tail[f] = node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */