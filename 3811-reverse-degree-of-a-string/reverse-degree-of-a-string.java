class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Position in reversed alphabet: 'a' -> 26, 'b' -> 25, ..., 'z' -> 1
            int reversedAlphabetPos = 26 - (c - 'a');
            
            // String position is 1-indexed
            int stringPos = i + 1;
            
            totalSum += reversedAlphabetPos * stringPos;
        }
        
        return totalSum;
    }
}