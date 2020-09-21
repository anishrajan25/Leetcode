class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, h = num;
        while (l <= h) {
            long m = l + (h - l) / 2;
            long x=m*m;
            if (x== num) return true;
            else if (x > num) h = m - 1;
            else if (x < num) l = m + 1;
        }
        return false;
    }
}