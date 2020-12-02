// https://leetcode.com/problems/n-th-tribonacci-number/

class Solution {
    public int tribonacci(int n) {
        if(n <= 2) return n == 2 ? 1 : n;
        int f = 0, s = 1, t = 1;
        while(n-- != 2) {
            int tmpt = t;
            t = f + s + t;
            f = s;
            s = tmpt;
        }
        
        return t;
    }
}