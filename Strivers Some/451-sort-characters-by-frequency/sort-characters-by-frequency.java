class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) freq[c]++;

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq[b] - freq[a]
        );

        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) pq.add((char) i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int count = freq[ch];
            while (count-- > 0) sb.append(ch);
        }

        return sb.toString();
    }
}
