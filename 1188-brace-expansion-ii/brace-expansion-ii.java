import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Character> ops = new Stack<>();
        Stack<Set<String>> operandStack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '{') {
                // If there was an implicit concatenation before '{', add continuous multiplication operator '*'
                if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                    while (!ops.isEmpty() && ops.peek() == '*') {
                        evaluate(ops, operandStack);
                    }
                    ops.push('*');
                }
                ops.push('{');
            } else if (c == '}') {
                while (!ops.isEmpty() && ops.peek() != '{') {
                    evaluate(ops, operandStack);
                }
                ops.pop(); // Pop '{'
            } else if (c == ',') {
                while (!ops.isEmpty() && ops.peek() != '{') {
                    evaluate(ops, operandStack);
                }
                ops.push(',');
            } else { // Lowercase letter
                // Check for implicit concatenation before letter
                if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                    while (!ops.isEmpty() && ops.peek() == '*') {
                        evaluate(ops, operandStack);
                    }
                    ops.push('*');
                }
                
                Set<String> set = new HashSet<>();
                set.add(String.valueOf(c));
                operandStack.push(set);
            }
        }
        
        while (!ops.isEmpty()) {
            evaluate(ops, operandStack);
        }
        
        List<String> result = new ArrayList<>(operandStack.pop());
        Collections.sort(result);
        return result;
    }

    private void evaluate(Stack<Character> ops, Stack<Set<String>> operandStack) {
        char op = ops.pop();
        Set<String> right = operandStack.pop();
        Set<String> left = operandStack.pop();
        Set<String> res = new HashSet<>();

        if (op == '*') { // Concatenation / Cartesian Product
            for (String l : left) {
                for (String r : right) {
                    res.add(l + r);
                }
            }
        } else if (op == ',') { // Union
            res.addAll(left);
            res.addAll(right);
        }
        
        operandStack.push(res);
    }
}