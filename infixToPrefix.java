class Solution {
    public String infixToPrefix(String s) {
        int n = s.length();

        StringBuilder rev = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') rev.append(')');
            else if (c == ')') rev.append('(');
            else rev.append(c);
        }

        char[] stack = new char[n];
        int top = -1;
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < rev.length(); i++) {
            char c = rev.charAt(i);

            if (c >= 'a' && c <= 'z') {
                postfix.append(c);
            }
            else if (c == '(') {
                stack[++top] = c;
            }
            else if (c == ')') {
                while (top >= 0 && stack[top] != '(') {
                    postfix.append(stack[top--]);
                }
                top--;
            }
            else {
                while (top >= 0 && precedence(stack[top]) >= precedence(c)) {
                    postfix.append(stack[top--]);
                }
                stack[++top] = c;
            }
        }

        while (top >= 0) {
            postfix.append(stack[top--]);
        }

        return postfix.reverse().toString();
    }

    private int precedence(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return -1;
    }
}
