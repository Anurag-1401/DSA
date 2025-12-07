class StockSpanner {

    static class Pair {
        int price;
        int span;

        Pair(int p, int s) {
            price = p;
            span = s;
        }
    }

    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Pop all prices ≤ current price
        while (!st.isEmpty() && st.peek().price <= price) {
            span += st.peek().span;
            st.pop();
        }

        // Push current pair
        st.push(new Pair(price, span));

        return span;
    }
}
