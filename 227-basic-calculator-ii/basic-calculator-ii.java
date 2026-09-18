class Solution {
    public int calculate(String s) {
        int n = s.length();
        int result = 0;
        int last = 0;
        int num = 0;
        char op = '+';

        for (int i = 0; i <= n; i++) {
            char c = i < n ? s.charAt(i) : '+';

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c != ' ') {
                if (op == '+') {
                    result += last;
                    last = num;
                } else if (op == '-') {
                    result += last;
                    last = -num;
                } else if (op == '*') {
                    last *= num;
                } else {
                    last /= num;
                }

                op = c;
                num = 0;
            }
        }

        return result + last;
    }
}