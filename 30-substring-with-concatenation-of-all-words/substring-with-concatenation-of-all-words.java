// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> result = new ArrayList<>();
//         if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

//         int wordLen = words[0].length();
//         int wordCount = words.length;
//         int totalLen = wordLen * wordCount;

//         if (s.length() < totalLen) return result;

//         for (int i = 0; i <= s.length() - totalLen; i++) {
//             String sub = s.substring(i, i + totalLen);

//             // Copy the words into a list for matching
//             List<String> wordList = new ArrayList<>(Arrays.asList(words));

//             // Break substring into words of length wordLen
//             boolean valid = true;
//             for (int j = 0; j < totalLen; j += wordLen) {
//                 String word = sub.substring(j, j + wordLen);
//                 if (wordList.contains(word)) {
//                     wordList.remove(word);
//                 } else {
//                     valid = false;
//                     break;
//                 }
//             }

//             if (valid) result.add(i);
//         }

//         return result;
//     }
// }




class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return result;

        // Count frequency of each word in words[]
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Loop through starting points
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // Too many of this word → shrink window from left
                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Found valid concatenation
                    if (count == wordCount) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Reset window if word not in words[]
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}

