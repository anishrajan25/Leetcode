// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length <= 1) return points.length;
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        int i = 0, x = -1, y = -1, c = 0;
        
        while(i < points.length - 1) {
            x = points[i][0];
            y = points[i][1];
            while(i < points.length - 1 && points[i+1][0] >= x && points[i+1][0] <= y) {
                i++;
                x = Math.min(x, points[i][0]);
                y = Math.min(y, points[i][1]);
                c++;
            }
            i++;
        }
        
        return points.length - c;
    }
}