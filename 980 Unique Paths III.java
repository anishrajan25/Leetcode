// https://leetcode.com/problems/unique-paths-iii/


class Solution {
    int ans, grid[][];
    
    Solution() {
        this.ans = 0;
    }
    
    private void getPaths(int r, int c, int n) {
        if(r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || grid[r][c] == -1) return;
        
        if(grid[r][c] == 2 && n == -1) {
            this.ans++;
            return;
        }
        
        int val = grid[r][c];
        grid[r][c] = -1;
        --n;
        
        getPaths(r, c + 1, n);
        getPaths(r, c - 1, n);
        getPaths(r + 1, c, n);
        getPaths(r - 1, c, n);
        
        grid[r][c] = val;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int c = 0, row = 0, col = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                if(grid[i][j] == 0) c++;
                else if(grid[i][j] == 1) {
                    row = i; col = j;
                }
            }
        }
        this.grid = grid;
        getPaths(row, col, c);
        return this.ans;
    }
}