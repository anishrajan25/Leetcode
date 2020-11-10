//  https://leetcode.com/problems/non-overlapping-intervals/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int c = 0;
        int e;
        
        for(int i = 0; i < intervals.length; i++) {
            e = intervals[i][1];
            while(i < intervals.length - 1 && e > intervals[i+1][0]) {
                c++;
                e = Math.min(e, intervals[++i][1]);
            }
        }
        return c;
    }
}