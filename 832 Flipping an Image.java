// https://leetcode.com/problems/flipping-an-image/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            int l = 0, r = A[i].length - 1;
            while(l <= r) {
                int t = A[i][l];
                A[i][l] = A[i][r] ^ 1;
                A[i][r] = t ^ 1;
                l++;
                r--;
            }
        }
        
        return A;
    }
}