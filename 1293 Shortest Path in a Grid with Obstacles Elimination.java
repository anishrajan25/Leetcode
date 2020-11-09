// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

class Solution {
    int[][][] memo;
    public int shortestPath(int[][] grid, int k) {
        if(k>=grid.length+grid[0].length-2) return grid.length+grid[0].length-2;
        memo = new int[grid.length][grid[0].length][k+1];
        return find(grid, 0, 0, k);
    }
    
    int find(int[][] grid, int i, int j, int k){
        if(i<0 || i>=grid.length) return -1;
        if(j<0 || j>=grid[0].length) return -1;
        if(i == grid.length-1 && j == grid[0].length-1)
            return 0;
        
        if(grid[i][j] == 2) return -1;
        if(grid[i][j] == 1 && k == 0) return -1;
        if(memo[i][j][k]!=0) return memo[i][j][k];
        
        if(grid[i][j] == 1) k-=1;
        int tmp = grid[i][j];
        grid[i][j] = 2;
        
        int min = -1;
        int r = find(grid, i+1, j, k);
        if(r != -1){
            if(min == -1) min = r;
            else min = Math.min(r, min);
        }
        r = find(grid, i-1, j, k);
        if(r != -1){
            if(min == -1) min = r;
            else min = Math.min(r, min);
        }
        r = find(grid, i, j+1, k);
        if(r != -1){
            if(min == -1) min = r;
            else min = Math.min(r, min);
        }
        r = find(grid, i, j-1, k);
        if(r != -1){
            if(min == -1) min = r;
            else min = Math.min(r, min);
        }
        grid[i][j] = tmp;
        
        if(min != -1) min+=1;
        memo[i][j][k] = min;
        return min;
    }
}