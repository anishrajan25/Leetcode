// https://leetcode.com/problems/longest-mountain-in-array/

class Solution {
    public int longestMountain(int[] A) {
        int lm = 0, i = 0;
        while(i < A.length) {
            int j = i;
            while(i < A.length - 1 && A[i] < A[i + 1]) i++;
            if(i > j) {
                int k = i;
                while(i < A.length - 1 && A[i] > A[i + 1]) i++;
                if(i > k) {
                    lm = Math.max(lm, i - j + 1);
                }
            }
            else i++;
        }
        
        return lm < 3 ? 0 : lm;
    }
}