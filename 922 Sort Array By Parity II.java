// https://leetcode.com/problems/sort-array-by-parity-ii/

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int o = 1;
        for(int i = 0; i < A.length; i+=2) {
            if(A[i]%2 == 1) {
                while(A[o]%2 == 1) o+=2;
                int t = A[o];
                A[o] = A[i];
                A[i] = t;
            }
        }
        
        return A;
    }
}