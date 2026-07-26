class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int max = 0, maxChar = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = i;
            }
        }

        if (max > (n + 1) / 2) return "";

        char[] result = new char[n];
        int index = 0;

        while (freq[maxChar] > 0) {
            result[index] = (char)(maxChar + 'a');
            index += 2;
            freq[maxChar]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (index >= n) index = 1;

                result[index] = (char)(i + 'a');
                index += 2;
                freq[i]--;
            }
        }

        return new String(result);
    }
}
