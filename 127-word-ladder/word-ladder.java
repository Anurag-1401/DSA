import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String word = q.poll();

                if (word.equals(endWord))
                    return level;

                char[] arr = word.toCharArray();

                for (int pos = 0; pos < arr.length; pos++) {

                    char original = arr[pos];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[pos] = ch;
                        String next = new String(arr);

                        if (dict.contains(next)) {
                            q.offer(next);
                            dict.remove(next);  // prevent revisit
                        }
                    }

                    arr[pos] = original; // restore
                }
            }

            level++;
        }

        return 0;
    }
}
