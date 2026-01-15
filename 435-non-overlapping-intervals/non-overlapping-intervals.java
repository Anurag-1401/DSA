// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//         int n = intervals.length;

//         Arrays.sort(intervals,(a,b) -> a[1]-b[1]);

//         int count =1,lastEnd = intervals[0][1];

//         for(int i=1;i<n;i++){
//             if(intervals[i][0] >= lastEnd){
//                 count++;
//                 lastEnd = intervals[i][1];
//             }
//         }

//         return n - count;
//     }
// }

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = intervals[0][1];
        int min = max;
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }
        int shift = 1 - min;
        int[] rightEnds = new int[max - min + 2];
        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (rightEnds[right] < left) rightEnds[right] = left;
        }
        int count = 0;
        int start = 0;
        for (int i = 1; i < rightEnds.length; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }
        return intervals.length - count;
    }
}