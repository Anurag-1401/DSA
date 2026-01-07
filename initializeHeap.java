class Solution {

    private ArrayList<Integer> heap;

    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int key) {
        heap.add(key);
        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) <= heap.get(i)) break;
            swap(i, parent);
            i = parent;
        }
    }

    public void changeKey(int index, int newVal) {
        if (index < 0 || index >= heap.size()) return;

        int oldVal = heap.get(index);
        heap.set(index, newVal);

        if (newVal < oldVal) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap.get(parent) <= heap.get(index)) break;
                swap(index, parent);
                index = parent;
            }
        } else {
            heapify(index);
        }
    }

    public void extractMin() {
        if (heap.isEmpty()) return;

        int lastIndex = heap.size() - 1;
        swap(0, lastIndex);
        heap.remove(lastIndex);
        heapify(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int getMin() {
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }

    public int heapSize() {
        return heap.size();
    }

    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
            smallest = left;

        if (right < heap.size() && heap.get(right) < heap.get(smallest))
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
