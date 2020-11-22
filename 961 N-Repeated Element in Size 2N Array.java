// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        if((A.length & 1) == 1) return A[A.length / 2];
        int i = A.length / 2;
        if(A[i] == A[i + 1]) return A[i];
        return A[i - 1];
    }
}