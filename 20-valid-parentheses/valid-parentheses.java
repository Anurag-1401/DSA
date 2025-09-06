class Solution {
    public boolean isValid(String s) {
        Stack<Character> para = new Stack<>();

        for (char c : s.toCharArray()){
            if(c =='(' || c=='{' || c=='[') para.push(c);
            else {
                if(para.isEmpty()) return false;
                char top = para.pop();
                if(top == '(' && c!=')' || top == '{' && c!='}' || top == '[' && c!=']') return false;
            }
        }
        return para.isEmpty();
    }
}