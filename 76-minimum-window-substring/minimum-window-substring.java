class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++)freq[t.charAt(i)]++;

        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char rc = s.charAt(right);

            if (freq[rc] > 0)required--;
            freq[rc]--;
            right++;

            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);
                freq[lc]++;
                if (freq[lc] > 0)required++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(start, start + minLen);
    }
}
