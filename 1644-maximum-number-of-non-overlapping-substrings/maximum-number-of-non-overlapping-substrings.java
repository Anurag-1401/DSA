import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Step 1: Record occurrences
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            if (first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Step 2: Build valid intervals
        for (int i = 0; i < n; i++) {

            int idx = s.charAt(i) - 'a';

            if (i != first[idx]) continue;

            int start = i;
            int end = last[idx];

            boolean valid = true;

            for (int j = start; j <= end; j++) {

                int c = s.charAt(j) - 'a';

                if (first[c] < start) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[c]);
            }

            if (valid)
                intervals.add(new int[]{start, end});
        }

        // Step 3: Greedy selection
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> res = new ArrayList<>();
        int prevEnd = -1;

        for (int[] in : intervals) {

            if (in[0] > prevEnd) {

                res.add(s.substring(in[0], in[1] + 1));
                prevEnd = in[1];
            }
        }

        return res;
    }
}