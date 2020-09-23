// https://leetcode.com/problems/arithmetic-slices/

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int ans = 0, l = 0, r = 2, pc = 0;
        
        while(r < A.length) {
            if(A[r] - A[r-1] == A[r-1] - A[r-2]) {
                pc++;
                ans += pc;
            }
            else pc = 0;
            ++r;
        }
        
        return ans;
    }
}