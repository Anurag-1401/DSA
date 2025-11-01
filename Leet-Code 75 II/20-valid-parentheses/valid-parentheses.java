class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char top;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                top = stack.pop();
                if (top == '(' && c != ')' ||
                    top == '[' && c != ']' ||
                    top == '{' && c != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
