class Solution {
    public String prefixToPostfix(String s) {
        int n = s.length();
        String[] stack = new String[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9')) {
                stack[++top] = String.valueOf(c);
            }
            else {
                String op1 = stack[top--];
                String op2 = stack[top--];

                String expr = op1 + op2 + c;
                stack[++top] = expr;
            }
        }

        return stack[top];
    }
}
