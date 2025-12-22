class Solution {
        int i = 0;
        long num = 0;
        int sign = 1;
        boolean start = false;

    public int myAtoi(String s) {
        // int n = s.length();

        // while (i < n && s.charAt(i) == ' ') i++;

        // if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        //     if (s.charAt(i) == '-') sign = -1;
        //     i++;
        // }

        // while (i < n && Character.isDigit(s.charAt(i))) {
        //     num = num * 10 + (s.charAt(i) - '0');

        //     if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        //     if (sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        //     i++;
        // }

        // return (int)(sign * num);





        if(i>=s.length()) return (int)(sign*num);

        char ch = s.charAt(i);

        if(!start && ch == ' '){
            i++;
            return myAtoi(s);
        }

        if(!start && (ch == '+' || ch == '-')){
            start = true;
            sign = ch == '+' ? 1:-1;
            i++;
            return myAtoi(s);
        }

        if(Character.isDigit(ch)){
            start = true;

            num = num*10 + (ch-'0');

            if(sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;

            return myAtoi(s);
        }
        return (int) (sign*num);
    }
}