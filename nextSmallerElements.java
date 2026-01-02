class Solution {
    public int[] nextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[i] < arr[stack[top]]) {
                ans[stack[top--]] = arr[i];
            }
            stack[++top] = i;
        }

        return ans;
    }
}
