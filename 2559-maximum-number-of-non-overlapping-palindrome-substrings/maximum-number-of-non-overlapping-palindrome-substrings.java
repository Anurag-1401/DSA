class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int n = s.length();
        int lastEnd = -1;

        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    if (l > lastEnd) {
                        count++;
                        lastEnd = r;
                        break;
                    }
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    if (l > lastEnd) {
                        count++;
                        lastEnd = r;
                        break;
                    }
                }
                l--;
                r++;
            }
        }

        return count;
    }
}