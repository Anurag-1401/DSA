class LinkedListQueue {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);

        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int pop() {
        if (isEmpty()) return -1;

        int val = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return val;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
