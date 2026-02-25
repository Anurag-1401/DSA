class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if(first[ch] == -1) first[ch] = i;
            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();
        for(int c = 0; c < 26; c++) {
            if(first[c] == -1) continue;

            int start = first[c];
            int end = last[c];
            boolean valid = true;
            for(int i = start; i <= end; i++) {
                int ch = s.charAt(i) - 'a';
                if(first[ch] < start) {
                    valid = false;
                    break;
                }
                end = Math.max(end, last[ch]);
            }
            if(valid) intervals.add(new int[]{start, end});
        } 
        intervals.sort((a, b) -> a[1] - b[1]);
        List<String> ans = new ArrayList<>();
        int prevEnd = -1;
        for(int[] i : intervals) {
            if(i[0] > prevEnd) {
                ans.add(s.substring(i[0], i[1] + 1));
                prevEnd = i[1];
            }
        }
        return ans;
    }
}