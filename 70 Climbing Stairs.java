// https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {
        int l = 1, sl = 1;
        for(int i = 2; i <= n; i++) {
            int t = l;
            l = sl + t;
            sl = t;
        }
        return l;
    }
}