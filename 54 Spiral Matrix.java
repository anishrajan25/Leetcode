// https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r = 0, c = 0;
        while(ans.size() != matrix.length * matrix[0].length) {
            int sr = r, sc = c;
            while(c < matrix[0].length - sc) ans.add(matrix[r][c++]);
            r++;
            c--;
            if(ans.size() == matrix.length * matrix[0].length) break;
            
            while(r < matrix.length - sr) ans.add(matrix[r++][c]);
            r--;
            c--;
            if(ans.size() == matrix.length * matrix[0].length) break;
            
            while(c >= sc) ans.add(matrix[r][c--]);
            r--;
            c++;
            if(ans.size() == matrix.length * matrix[0].length) break;
            
            while(r > sr) ans.add(matrix[r--][c]);
            r++;
            c++;
            if(ans.size() == matrix.length * matrix[0].length) break;
        }
        
        return ans;
    }
}