// https://leetcode.com/problems/remove-covered-intervals/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {        
        boolean[] covered = new boolean[intervals.length];
        int ans = intervals.length;
        for(int i = 0; i < intervals.length; i++){
            if(!covered[i]){
                int a = intervals[i][0];
                int b = intervals[i][1];
                for(int j = 0; j < intervals.length; j++) {
                    if(i !=j && !covered[j]) {
                        int c = intervals[j][0];
                        int d = intervals[j][1];
                        if(a <= c && b >= d) {
                            covered[j] = true;
                            ans--;
                        }
                    }
                } 
            }
        }
        return ans;
    }
}

// class Solution {
//     public int removeCoveredIntervals(int[][] intervals) {
//         if(intervals.length == 0) return 0;
//         Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
//         int ans = intervals.length, em = intervals[0][1];
//         for(int i = 0; i < intervals.length - 1; ++i)
//             if(em >= intervals[i+1][1]) ans--;
//             else em = intervals[i+1][1];
//         return ans;
//     }
// }