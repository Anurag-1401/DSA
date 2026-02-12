import java.util.*;

class Solution {
    public List<Integer> longestIncreasingSubsequence(int[] arr) {

        int n = arr.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;  // self-parent initially

            for (int prev = 0; prev < i; prev++) {

                if (arr[i] > arr[prev]) {

                    // Better LIS found
                    if (dp[prev] + 1 > dp[i]) {
                        dp[i] = dp[prev] + 1;
                        parent[i] = prev;
                    }

                    // Equal length → pick lexicographically smaller
                    else if (dp[prev] + 1 == dp[i]) {
                        if (prev < parent[i]) {
                            parent[i] = prev;
                        }
                    }
                }
            }
        }

        // Find index of maximum LIS
        int lisEnd = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[lisEnd]) {
                lisEnd = i;
            }
        }

        // Reconstruct LIS
        List<Integer> res = new ArrayList<>();

        while (parent[lisEnd] != lisEnd) {
            res.add(arr[lisEnd]);
            lisEnd = parent[lisEnd];
        }

        res.add(arr[lisEnd]);

        Collections.reverse(res);

        return res;
    }
}
