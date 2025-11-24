class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()) {

            // While we can remove digits
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }

            st.push(c);
        }

        // If still k > 0, remove from end
        while (k > 0) {
            st.pop();
            k--;
        }

        // Build answer
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
