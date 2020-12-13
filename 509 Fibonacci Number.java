// https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int N) {
        if(N <= 1) return N;
        int f = 0, s = 1;
        while(N-- != 1) {
            int t = f + s;
            f = s;
            s = t;
        }
        
        return s;
    }
}