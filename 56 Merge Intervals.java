// https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int k = 0, i = 0;
        while(i < intervals.length) {
            int j = intervals[i][0], m = intervals[i][1];
            while(i < intervals.length - 1 && intervals[i + 1][0] <= m) m = Math.max(m, intervals[++i][1]);
            res[k][0] = j;
            res[k++][1] = m;
            i++;
        }
        
        return Arrays.copyOfRange(res, 0, k);
    }
}