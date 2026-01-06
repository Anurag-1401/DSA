class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l=0,maxF=0,maxL=0;

        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            freq[ch-'A']++;

            if(freq[ch-'A']>maxF) maxF = freq[ch-'A'];

            while((r-l+1)-maxF > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            int curr = r-l+1;
            if(curr>maxL) maxL = curr;
        }
        return maxL;
    }
}