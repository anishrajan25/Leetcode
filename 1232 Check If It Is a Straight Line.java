class Solution {
    public boolean checkStraightLine(int[][] co) {
        int x = co[0][0], y = co[0][1], x1 = co[1][0], y1 = co[1][1];
        int dx = x1 - x, dy = y1 - y;
        for (int[] c : co) {
            x = c[0]; y = c[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}