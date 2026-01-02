class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;

        int[] left = new int[n];
        int[] right = new int[n];

        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] > arr[i]) {
                top--;
            }
            left[i] = (top == -1) ? (i + 1) : (i - stack[top]);
            stack[++top] = i;
        }

        top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }
            right[i] = (top == -1) ? (n - i) : (stack[top] - i);
            stack[++top] = i;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}
