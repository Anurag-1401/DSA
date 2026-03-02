class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l=0,maxL=0;

        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            freq[ch]++;

            while(l<=r && freq[ch]>1){
                freq[s.charAt(l)]--;
                l++;
            }

            int curr = r-l+1;
            if(curr > maxL) maxL = curr;
        }
        return maxL;
    }
}