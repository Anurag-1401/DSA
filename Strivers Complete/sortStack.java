class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) return;

        int x = st.pop();

        sortStack(st);

        insert(st,x);
    }

    private void insert(Stack<Integer> st,int val){
        if(st.isEmptay() || val>=st.peek()){
            st.push(val);
             return;
        }

        int top = st.pop();
        insert(st,val);
        st.push(top);
    }
}
