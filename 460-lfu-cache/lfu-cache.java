class LFUCache {

    private final int capacity;
    private int minFreq;

    private Map<Integer, Integer> keyToValue = new HashMap<>();
    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key))
            return -1;

        increaseFreq(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }

        if (keyToValue.size() >= capacity) {
            // Evict LRU inside minFreq list
            LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
            int lruKey = keys.iterator().next();  // first element = LRU
            keys.remove(lruKey);

            keyToValue.remove(lruKey);
            keyToFreq.remove(lruKey);
        }

        // Insert new key with freq = 1
        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);

        minFreq = 1;  // reset
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        LinkedHashSet<Integer> set = freqToKeys.get(freq);
        set.remove(key);

        if (freq == minFreq && set.isEmpty()) {
            minFreq++;
        }

        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }
}