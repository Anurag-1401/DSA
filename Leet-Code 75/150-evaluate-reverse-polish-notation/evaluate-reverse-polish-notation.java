class Solution {
    public int evalRPN(String[] tokens) {
        // Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(String token : tokens){
            if(token.equals("+")) stack.push(stack.pop() + stack.pop());
            else if(token.equals("-")) {
                int b = stack.pop(),a=stack.pop();
                stack.push(a - b);
            }else if(token.equals("*")) stack.push(stack.pop() * stack.pop());
            else if(token.equals("/")) {
                 int b = stack.pop(),a=stack.pop();
                stack.push(a / b);
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}