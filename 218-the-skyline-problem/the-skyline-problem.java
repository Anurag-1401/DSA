import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> events = new ArrayList<>();

        // Build line-sweep events
        // Represent start events with negative height and end events with positive height
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // Start point
            events.add(new int[]{b[1], b[2]});  // End point
        }

        // Sort events:
        // 1. By x-coordinate ascending
        // 2. If x is same:
        //    - Two starts: larger height first (more negative)
        //    - Two ends: smaller height first
        //    - Start and end: start comes first (negative < positive)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Map to keep track of active building heights and their frequencies
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1); // Baseline height 0

        int prevMaxHeight = 0;

        for (int[] event : events) {
            int x = event[0];
            int height = event[1];

            if (height < 0) {
                // Add new building height
                heightMap.put(-height, heightMap.getOrDefault(-height, 0) + 1);
            } else {
                // Remove ending building height
                int count = heightMap.get(height);
                if (count == 1) {
                    heightMap.remove(height);
                } else {
                    heightMap.put(height, count - 1);
                }
            }

            int currentMaxHeight = heightMap.lastKey();

            // If maximum height changes, record a new key point
            if (prevMaxHeight != currentMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }
}