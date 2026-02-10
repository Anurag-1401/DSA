class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        generate(left, leftSums);
        generate(right, rightSums);

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int result = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = leftSums[k];
            List<Integer> rightList = rightSums[n - k];

            for (int x : leftList) {
                int target = totalSum / 2 - x;

                int idx = Collections.binarySearch(rightList, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < rightList.size()) {
                    int sum = x + rightList.get(idx);
                    result = Math.min(result,
                            Math.abs(totalSum - 2 * sum));
                }

                if (idx > 0) {
                    int sum = x + rightList.get(idx - 1);
                    result = Math.min(result,
                            Math.abs(totalSum - 2 * sum));
                }
            }
        }

        return result;
    }

    private void generate(int[] arr, List<Integer>[] sums) {
        int n = arr.length;
        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            int size = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    size++;
                    sum += arr[i];
                }
            }
            sums[size].add(sum);
        }
    }
}
