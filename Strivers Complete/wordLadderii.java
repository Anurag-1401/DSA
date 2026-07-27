class Solution {

    HashMap<String, Integer> map = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    String begin;

    public void dfs(String word, ArrayList<String> path) {

        if (word.equals(begin)) {
            ArrayList<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int steps = map.get(word);

        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {

                arr[i] = ch;
                String prev = new String(arr);

                if (map.containsKey(prev) && map.get(prev) == steps - 1) {

                    path.add(prev);
                    dfs(prev, path);
                    path.remove(path.size() - 1);
                }
            }

            arr[i] = original;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        begin = beginWord;

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return ans;

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        map.put(beginWord, 0);

        set.remove(beginWord);

        while (!queue.isEmpty()) {

            String word = queue.poll();
            int steps = map.get(word);

            if (word.equals(endWord))
                break;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String next = new String(arr);

                    if (set.contains(next)) {

                        queue.offer(next);
                        map.put(next, steps + 1);
                        set.remove(next);
                    }
                }

                arr[i] = original;
            }
        }

        if (map.containsKey(endWord)) {

            ArrayList<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path);
        }

        return ans;
    }
}
