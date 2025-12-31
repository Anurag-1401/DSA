class ArrayStack {
    int[] arr;
    int top;
    int cap = 1000;
    public ArrayStack() {
        arr = new int[cap];
        top = -1;
    }

    public void push(int x) {
       if(top == cap - 1) return;
       arr[++top] = x;
    }

    public int pop() {
      if(isEmpty()) return -1;
      return arr[top--];
    }

    public int top() {
      if(isEmpty()) return -1;
      return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
