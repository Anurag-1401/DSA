class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0,maxF = 0,maxL = 0;
        int[] freq = new int[26];

        for (int r = 0; r < s.length(); r++) {
            maxF = Math.max(maxF, ++freq[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxF > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            maxL = Math.max(maxL, (r - l + 1));
        }
        return maxL;
    }
}