// https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int l = 0, h = matrix.length - 1;
        
        while(l < h) {
            int m = l + (h - l) / 2;
            if(matrix[m][0] == target) return true;
            if(matrix[m][0] < target) {
                if(matrix[m][matrix[m].length - 1] >= target) {
                    l = m;
                    break;
                } else l = m + 1;
            } else h = m - 1;
        }
        
        h = matrix[l].length;
        int r = l;
        l = 0;
        while(l < h) {
            int m = l + (h - l) / 2;
            if(matrix[r][m] == target) return true;
            if(matrix[r][m] > target) h = m;
            else l = m + 1;
        }
        
        return false;
    }
}