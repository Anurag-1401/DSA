class ArrayQueue {
    int[] arr;
    int front;
    int rear;
    int capacity = 1000;
    public ArrayQueue() {
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void push(int x) {
       if(rear == capacity-1) return;
       arr[++rear] = x;
    }

    public int pop() {
      if(isEmpty()){
        return -1;
      }
      return arr[front++];
    }

    public int peek() {
        if(isEmpty()){
        return -1;
      }
      return arr[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }
}
