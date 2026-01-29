class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;

        int[] lps = buildLPS(temp);
        int longestPrefixPalindrome = lps[temp.length() - 1];

        String toAdd = rev.substring(0, s.length() - longestPrefixPalindrome);
        return toAdd + s;
    }

    private int[] buildLPS(String str) {
        int[] lps = new int[str.length()];
        int len = 0;
        int i = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        return lps;
    }
}
