class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char c:tasks) freq[c-'A']++;

        int maxF = 0;
        for(int f:freq) maxF = Math.max(maxF,f);

        int maxC = 0;
        for(int f:freq) {
            if(f == maxF) maxC++;
        }

        return Math.max(tasks.length,(maxF-1)*(n+1)+maxC);
    }
}
