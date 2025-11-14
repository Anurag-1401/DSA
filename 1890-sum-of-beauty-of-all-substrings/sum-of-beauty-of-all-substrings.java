class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26]; // frequency for current starting index

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxF = 0, minF = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        maxF = Math.max(maxF, f);
                        minF = Math.min(minF, f);
                    }
                }

                ans += (maxF - minF);
            }
        }
        return ans;
    }
}
