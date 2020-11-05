// https://leetcode.com/problems/diagonal-traverse/


class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        if(matrix.length == 1) return matrix[0];
        int r = matrix.length, c = matrix[0].length, i = 0, j = 0;
        int[] res = new int[r*c];
        int k = 0;
        
        while(k < r*c) {
            while(i > -1 && j < c) {
                res[k++] = matrix[i--][j++];
            }
            
            i++;
            if(j >= c) {j = c - 1; i++;}
            while(i < r && j > -1) {
                res[k++] = matrix[i++][j--];
            }
            
            j++;
            if(i >= r) {i = r - 1; j++;}
        }
        
        return res;
    }
}