class Solution {
    public boolean isSubsequence(String s, String t) {
      
        int sInd = 0;

        for(int i=0;i<t.length() && sInd<s.length();i++){
            if(s.charAt(sInd) == t.charAt(i)) sInd++;
            
        }
        return sInd == s.length();
    }
}