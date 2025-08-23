class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return steps;

                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        arr[j] = c;
                        String next = new String(arr);
                        if (dict.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            steps++;
        }
        return 0;
    }
}
