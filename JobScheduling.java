import java.util.*;

class Solution {
    public int[] JobScheduling(int[][] Jobs) {

        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        int maxDeadline = 0;
        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        boolean[] slot = new boolean[maxDeadline + 1];

        int jobCount = 0;
        int maxProfit = 0;

        for (int[] job : Jobs) {
            int deadline = job[1];
            int profit = job[2];

            for (int t = deadline; t > 0; t--) {
                if (!slot[t]) {
                    slot[t] = true;
                    jobCount++;
                    maxProfit += profit;
                    break;
                }
            }
        }

        return new int[]{jobCount, maxProfit};
    }
}
