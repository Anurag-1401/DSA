class Solution {
    public int LongestBitonicSequence(int[] arr) {

        int n = arr.length;

        int[] lis = new int[n];
        int[] lds = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev]) {
                    lis[i] = Math.max(lis[i], lis[prev] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int next = n - 1; next > i; next--) {
                if (arr[i] > arr[next]) {
                    lds[i] = Math.max(lds[i], lds[next] + 1);
                }
            }
        }

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, lis[i] + lds[i] - 1);
        }

        return maxLen;
    }
}
