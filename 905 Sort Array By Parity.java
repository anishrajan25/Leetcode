// https://leetcode.com/problems/sort-array-by-parity/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;
        while(l < r) {
            if((A[l] & 1) == 0) ++l;
            if((A[r] & 1) == 1) --r;
            else if((A[l] & 1) == 1 && (A[r] & 1) == 0) {
                int t = A[l];
                A[l] = A[r];
                A[r] = t;
                ++l;
                --r;
            }
        }
        
        return A;
    }
}