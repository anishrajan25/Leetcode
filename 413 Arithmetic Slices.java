// https://leetcode.com/problems/arithmetic-slices/


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int ans = 0, i = 0, j = 0;
        
        while(i < A.length - 1) {
            int d = A[i + 1] - A[i];
            j = i++;
            while(i < A.length - 1 && A[i + 1] - A[i] == d) i++;
            int len = i - j + 1 - 2;
            if(len > -1) ans += len * (len + 1) / 2;
        }
        return ans;
    }
}

// SOLUTION II
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
