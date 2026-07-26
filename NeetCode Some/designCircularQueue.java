class MyCircularQueue {
    int[] q;
    int front, rear, size, capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        q = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        q[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return q[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return q[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
