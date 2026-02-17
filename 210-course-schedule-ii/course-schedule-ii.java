class Solution {
    private int[] next, to, head, degree, ans;
    private int nodeIndex = 0, index = 0;
    private void add(int a, int b) {
        next[nodeIndex] = head[a];
        to[nodeIndex] = b;
        head[a] = nodeIndex++;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        this.degree = new int[numCourses];
        this.ans = new int[numCourses];
        this.head = new int[numCourses];
        this.next = new int[m];
        this.to = new int[m];
        Arrays.fill(head, -1);

        for(int[] req : prerequisites) {
            degree[req[0]]++;
            add(req[1], req[0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) dfs(i);
        }
        return index == numCourses ? ans : new int[0];
    }
    private void dfs(int i) {
        degree[i] = -1;
        ans[index++] = i;
        for(int j = head[i]; j != -1; j = next[j]) {
            if(--degree[to[j]] == 0) dfs(to[j]);
        }
    }
}