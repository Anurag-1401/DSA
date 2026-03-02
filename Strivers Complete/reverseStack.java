class Solution {

    public void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();

        reverseStack(st);

        insertAtBottom(st, top);
    }

    private void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        int temp = st.pop();
        insertAtBottom(st, val);
        st.push(temp);
    }
}
