class Solution {
    private boolean isPalin(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1,delOne = 0;
        while (left < right) { 
            if(s.charAt(left)!=s.charAt(right)) {
                return isPalin(s,left+1,right) || isPalin(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
}
