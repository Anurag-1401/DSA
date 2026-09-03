class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0;i<numRows;i++) rows[i] = new StringBuilder();

        int curr = 0;
        boolean down = false;

        for(int i = 0;i<s.length();i++){
            rows[curr].append(s.charAt(i));

            if(curr == 0 || curr == numRows-1) down = !down;

            curr = down ? curr+1 : curr-1; 
        }

        String ans = "";
        for(StringBuilder row:rows) ans+=row;

        return ans;
    }
}