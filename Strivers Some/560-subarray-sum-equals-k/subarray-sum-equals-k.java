class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == k) count++;

            int val = prefixSum[i] - k;
            if (map.containsKey(val)) {
                count += map.get(val);
            }

            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }
}