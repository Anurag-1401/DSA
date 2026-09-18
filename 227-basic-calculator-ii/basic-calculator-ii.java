class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        int result = 0;
        int lastNumber = 0;
        int currentNumber = 0;
        char lastOperator = '+';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }

            if ((!Character.isDigit(currentChar) && currentChar != ' ') || i == s.length() - 1) {
                if (lastOperator == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (lastOperator == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (lastOperator == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (lastOperator == '/') {
                    lastNumber = lastNumber / currentNumber;
                }

                lastOperator = currentChar;
                currentNumber = 0;
            }
        }

        result += lastNumber;
        return result;
    }
}