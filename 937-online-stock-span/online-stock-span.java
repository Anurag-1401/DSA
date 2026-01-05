class StockSpanner {

    int[] p;
    int[] s;
    int top,i;

    public StockSpanner() {
        p = new int[10000];
        s = new int[10000];
        top = -1;
        i=0;
    }
    
    public int next(int price) {
        p[i] = price;

        while(top>=0 && p[s[top]] <= price) top--;

        int span;
        if(top == -1) span = i+1;
        else span = i - s[top];

        s[++top] = i++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */