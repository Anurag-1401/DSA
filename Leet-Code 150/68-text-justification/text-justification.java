class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int j = i + 1;
            int lineLen = words[i].length();

            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length(); 
                j++;
            }

            int wordCount = j - i;
            int totalSpaces = maxWidth - lineLen + (wordCount - 1);
            StringBuilder sb = new StringBuilder();

            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }

                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                int spaces = totalSpaces / (wordCount - 1);
                int extra = totalSpaces % (wordCount - 1);

                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    for (int s = 0; s < spaces + (k - i < extra ? 1 : 0); s++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[j - 1]);
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}
