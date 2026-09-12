import java.util.*;

class Solution {
    private static class Interval {
        int l, r, weight, id;

        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i);
        }

        // Sort intervals by right endpoint
        Arrays.sort(arr, (a, b) -> {
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.id, b.id);
        });

        // Precalculate predecessor index for each interval using binary search
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1, ans = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (arr[mid].r < arr[i].l) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prev[i] = ans;
        }

        // dp[k][i]: Best choice of up to k intervals using prefix [0...i]
        long[][] dpWeight = new long[5][n];
        List<Integer>[][] dpIndices = new ArrayList[5][n];

        // Initialize dpIndices to avoid NullPointerException
        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i < n; i++) {
                dpIndices[k][i] = new ArrayList<>();
            }
        }

        for (int k = 1; k <= 4; k++) {
            for (int i = 0; i < n; i++) {
                // Option 1: Skip interval i
                long w1 = (i > 0) ? dpWeight[k][i - 1] : 0;
                List<Integer> list1 = (i > 0) ? dpIndices[k][i - 1] : new ArrayList<>();

                // Option 2: Pick interval i
                int p = prev[i];
                long w2 = arr[i].weight + (p != -1 ? dpWeight[k - 1][p] : 0);
                List<Integer> list2 = new ArrayList<>(p != -1 ? dpIndices[k - 1][p] : Collections.emptyList());
                list2.add(arr[i].id);
                Collections.sort(list2);

                // Compare weight and lexicographical order
                if (w2 > w1) {
                    dpWeight[k][i] = w2;
                    dpIndices[k][i] = list2;
                } else if (w1 > w2) {
                    dpWeight[k][i] = w1;
                    dpIndices[k][i] = list1;
                } else {
                    dpWeight[k][i] = w1;
                    dpIndices[k][i] = compareLex(list1, list2) <= 0 ? list1 : list2;
                }
            }
        }

        // Find best choice across all k (1 to 4)
        long maxWeight = -1;
        List<Integer> bestIndices = new ArrayList<>();

        for (int k = 1; k <= 4; k++) {
            long w = dpWeight[k][n - 1];
            List<Integer> idxs = dpIndices[k][n - 1];
            if (w > maxWeight) {
                maxWeight = w;
                bestIndices = idxs;
            } else if (w == maxWeight && compareLex(idxs, bestIndices) < 0) {
                bestIndices = idxs;
            }
        }

        int[] result = new int[bestIndices.size()];
        for (int i = 0; i < bestIndices.size(); i++) {
            result[i] = bestIndices.get(i);
        }
        return result;
    }

    private int compareLex(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}