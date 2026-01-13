import java.util.Arrays;

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int platformsNeeded = 1;
        int maxPlatforms = 1;

        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                platformsNeeded++;
                i++;
            } else {
                platformsNeeded--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }
}
