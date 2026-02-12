import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 0; i < n; i++) {

            for (int prev = 0; prev < i; prev++) {

                if (isPredecessor(words[prev], words[i])) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    private boolean isPredecessor(String a, String b) {

        if (b.length() != a.length() + 1) return false;

        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {

            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == a.length();
    }
}
