class Solution {

    class Pair {
        int sum;
        int i;
        int j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        reverse(nums1);
        reverse(nums2);

        PriorityQueue<Pair> maxHeap =
            new PriorityQueue<>((a, b) -> b.sum - a.sum);

        Set<String> visited = new HashSet<>();

        maxHeap.offer(new Pair(nums1[0] + nums2[0], 0, 0));
        visited.add("0#0");

        int[] result = new int[k];
        int idx = 0;

        while (idx < k && !maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            result[idx++] = curr.sum;

            int i = curr.i;
            int j = curr.j;

            if (i + 1 < n && !visited.contains((i + 1) + "#" + j)) {
                maxHeap.offer(new Pair(nums1[i + 1] + nums2[j], i + 1, j));
                visited.add((i + 1) + "#" + j);
            }

            if (j + 1 < n && !visited.contains(i + "#" + (j + 1))) {
                maxHeap.offer(new Pair(nums1[i] + nums2[j + 1], i, j + 1));
                visited.add(i + "#" + (j + 1));
            }
        }

        return result;
    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
