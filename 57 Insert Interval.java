// https://leetcode.com/problems/insert-interval/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
        int[][] res = new int[intervals.length + 1][2];
        int k = 0, i = 0;
        boolean added = false;
        while(i < intervals.length) {
            if(intervals[i][1] >= newInterval[0]) {
                int j = Math.min(intervals[i][0], newInterval[0]), m = newInterval[1];
                if(newInterval[1] >= intervals[i][0]) {
                    m = Math.max(intervals[i][1], newInterval[1]);
                    while(i < intervals.length - 1 && intervals[i + 1][0] <= m) m = Math.max(m, intervals[++i][1]);
                    res[k][0] = j;
                    res[k++][1] = m;
                    i++;
                } else {
                    res[k++] = newInterval;
                }
                added = true;
                break;
            }
            res[k++] = intervals[i++];
        }
        while(i < intervals.length) res[k++] = intervals[i++];
        if(!added) {
            res[k++] = newInterval;
            return res;
        }
        return Arrays.copyOfRange(res, 0, k);
    }
}