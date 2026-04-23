/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval meeting : intervals) {

            if (!minHeap.isEmpty() && meeting.start >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.offer(meeting.end);
        }

        return minHeap.size();
    }
}
