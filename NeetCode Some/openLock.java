class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (dead.contains(curr)) continue;

                if (curr.equals(target)) return moves;

                for (String next : getNeighbors(curr)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private static List<String> getNeighbors(String s) {
        List<String> res = new ArrayList<>();

        char[] arr = s.toCharArray();

        for (int i = 0; i < 4; i++) {

            char ch = arr[i];

            arr[i] = (char) ((ch - '0' + 1) % 10 + '0');
            res.add(new String(arr));

            arr[i] = (char) ((ch - '0' + 9) % 10 + '0');
            res.add(new String(arr));

            arr[i] = ch;
        }

        return res;
    }
}
