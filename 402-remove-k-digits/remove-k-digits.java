class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";

        char[] digits = num.toCharArray();
        char[] stack = new char[digits.length];
        int top = -1,count = k;

        for(int i =0;i<digits.length;i++){
            while(count>0 && top>=0 && stack[top]>digits[i]) {
                top--;
                count--;
            }
            stack[++top] = digits[i];
        }

        top -= count;

        int non0Start = 0;
        while(non0Start<=top && stack[non0Start] == '0'){
            non0Start++;
        }

        if(non0Start > top) return "0";

        return String.valueOf(stack,non0Start,top - non0Start + 1);
    }
}