// https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] st = new int[T.length];
        int i = 0;
        for(int x = 0; x < T.length; x++) {
            while(i > 0 && T[x] > T[st[i - 1]]) {
                int p = st[--i];
                T[p] = x - p;
            }
            st[i++] = x;
        }
        
        while(i > 0) {
            T[st[--i]] = 0;
        }
        
        return T;
    }
}