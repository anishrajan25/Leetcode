// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0, l = 0, r = 0, prev_count = 0;
        
        while(r < A.length) {
            if(A[r] > R) {
                l = r+1;
                prev_count = 0;
            }
            else if(A[r] >= L && A[r] <= R) {
                res += r - l + 1;
                prev_count = r - l + 1;
            }
            else res += prev_count;
            r += 1;
        }
        return res;
    }
}