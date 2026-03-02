class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int minLen = Integer.MAX_VALUE;
        int start = -1;

        int i = 0;

        while (i < n) {
            int j = 0;

            while (i < n) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == m) break;
                }
                i++;
            }

            if (j < m) break;

            int end = i;
            j = m - 1;

            while (i >= 0) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j--;
                    if (j < 0) break;
                }
                i--;
            }

            int windowLen = end - i + 1;
            if (windowLen < minLen) {
                minLen = windowLen;
                start = i;
            }

            i = i + 1;
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }
}
