class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String op : tokens) {
            switch (op) {
                case "+":
                    int first = stack[top--];
                    int second = stack[top--];
                    stack[++top] = first + second;
                    break;
                case "-":
                    first = stack[top--];
                    second = stack[top--];
                    stack[++top] = second - first;
                    break;
                case "*":
                    first = stack[top--];
                    second = stack[top--];
                    stack[++top] = first * second;
                    break;
                case "/":
                    first = stack[top--];
                    second = stack[top--];
                    stack[++top] = second / first;
                    break;
                default:
                    stack[++top] = Integer.parseInt(op);
                    break;
            }
        }

        return stack[top];
    }
}