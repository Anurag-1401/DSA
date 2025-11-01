class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int freq = 0,max=0,left=0;
        char c;

        for(int right=0;right<s.length();right++){
            c = s.charAt(right);
            count[c-'A']++;
            freq= Math.max(freq,count[c-'A']);

            while((right-left+1) - freq > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}