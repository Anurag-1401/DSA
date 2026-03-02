class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int j=0,i=s.length()-1;

        while(i>=0){
            while(i>=0 && s.charAt(i) == ' ') i--;
            if(i<0) break;

            j=i;
            while(j>=0 && s.charAt(j) != ' ') j--;
            res.append(s.substring(j+1,i+1));
            res.append(" ");
            i=j-1;
        }
        return res.toString().trim();
    }
}