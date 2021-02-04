// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ans = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, memo);
                ans = Math.max(ans, len);
            }
        }   
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if(memo[i][j] != 0) return memo[i][j];
        int ans = 1;
        if(i > 0 && matrix[i][j] > matrix[i - 1][j]) ans = Math.max(ans, 1 + dfs(matrix, i - 1, j, m, n, memo));
        if(j > 0 && matrix[i][j] > matrix[i][j - 1]) ans = Math.max(ans, 1 + dfs(matrix, i, j - 1, m, n, memo));
        if(i < m - 1 && matrix[i][j] > matrix[i + 1][j]) ans = Math.max(ans, 1 + dfs(matrix, i + 1, j, m, n, memo));
        if(j < n - 1 && matrix[i][j] > matrix[i][j + 1]) ans = Math.max(ans, 1 + dfs(matrix, i, j + 1, m, n, memo));
        
        return memo[i][j] = ans;
    }
}