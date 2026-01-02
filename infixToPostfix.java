class Solution {
    public String infixToPostfix(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        StringBuilder ans = new StringBuilder();

        for(char c:s.toCharArray()){
            if((c >= 'a' && c <= 'z' )|| (c >= '0' && c<= '9')) ans.append(c);

            else if(c == '(') stack[++top] = c;

            else if(c == ')'){
                while(top>=0 && stack[top] != '(') ans.append(stack[top--]);
                top--;
            }

            else {
                if(top>=0 && presedence(stack[top]) > c ||
                    top>=0 && presedence(stack[top]) == c && c != '^'){
                        ans.append(stack[top--]);
                    }

                stack[++top] = c;    
            }
        }

        while(top>=0) ans.append(stack[top--]);

        return ans.toString();
    }

    private int presedence(char op){
        if(op == '^') return 3;
        else if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return -1;
    }
}
