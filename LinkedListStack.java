class LinkedListStack {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public LinkedListStack() {
        top = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) return -1;

        int val = top.data;
        top = top.next;
        return val;
    }

    public int top() {
        if (isEmpty()) return -1;
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
