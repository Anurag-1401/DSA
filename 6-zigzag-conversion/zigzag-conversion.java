// class Solution {
//     public String convert(String s, int numRows) {
//         if(numRows <= 1 || s.length() <= numRows) return s;

//         StringBuilder[] rows = new StringBuilder[numRows];
//         for(int i = 0;i<numRows;i++) rows[i] = new StringBuilder();

//         int curr = 0;
//         boolean down = false;

//         for(int i = 0;i<s.length();i++){
//             rows[curr].append(s.charAt(i));

//             if(curr == 0 || curr == numRows-1) down = !down;

//             curr = down ? curr+1 : curr-1; 
//         }

//         String ans = "";
//         for(StringBuilder row:rows) ans+=row;

//         return ans;
//     }
// }





class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;
        
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for(int i = 0; i < numRows; i++){
            for(int j = 0 ; j + i < n; j += cycleLen){
                sb.append(s.charAt(j + i));
                if(i != 0 && i != numRows - 1 && j + cycleLen - i < n){
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        
        return sb.toString();
    }
}