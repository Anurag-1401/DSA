class MyCircularQueue {

    int[] q;
    int f,r,s,c;

    public MyCircularQueue(int k) {
        q = new int[k];
        f=0;
        r=-1;
        s=0;
        c=k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        r = (r+1) % c;
        q[r] = value;
        s++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        f = (f+1) % c;
        s--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return q[f];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return q[r];
    }
    
    public boolean isEmpty() {
        if(s == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(s == c) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */