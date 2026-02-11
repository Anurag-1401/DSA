class Solution {
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[] grid = new boolean[m + 1];

        // Base case: empty string vs pattern
        grid[0] = true;

        // Handle patterns like "*", "**", "***"
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                grid[j] = grid[j - 1];
        }

        for (int i = 1; i <= n; i++) {

            boolean[] curr = new boolean[m + 1];
            curr[0] = false; // non-empty string vs empty pattern

            for (int j = 1; j <= m; j++) {

                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    curr[j] = curr[j - 1] || grid[j];
                }
                else if (pc == '?' || pc == s.charAt(i - 1)) {
                    curr[j] = grid[j - 1];
                }
            }

            grid = curr;
        }

        return grid[m];
    }
}
