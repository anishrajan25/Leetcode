// https://leetcode.com/problems/maximize-distance-to-closest-person/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int d = 0, si = -1, l = 0, r = seats.length;
        while(seats[l] != 1) l++;
        d = Math.max(d, l);
        while(seats[r-1] != 1) r--;
        d = Math.max(d, seats.length - r);
        while(l < r) {
            int j = l;
            while(l < r - 1 && seats[l+1] == 0) l++;
            d = Math.max(d, (l - j + 1)/2);
            l++;
        }
        return d;
    }
}