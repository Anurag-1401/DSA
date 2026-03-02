class Solution {
    public String prefixToInfix(String s) {
        int n = s.length();
        String[] stack = new String[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                stack[++top] = String.valueOf(c);
            }

            else {
                String op1 = stack[top--];
                String op2 = stack[top--];

                String expr = "(" + op1 + c + op2 + ")";
                stack[++top] = expr;
            }
        }

        return stack[top];
    }
}
