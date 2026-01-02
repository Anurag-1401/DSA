class Solution {
    public String postToPre(String s) {
        int n = s.length();
        String[] stack = new String[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                stack[++top] = String.valueOf(c);
            }
            else {
                String op2 = stack[top--];
                String op1 = stack[top--];

                String expr = c + op1 + op2;
                stack[++top] = expr;
            }
        }

        return stack[top];
    }
}
