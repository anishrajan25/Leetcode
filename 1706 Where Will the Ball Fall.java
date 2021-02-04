// https://leetcode.com/problems/where-will-the-ball-fall/submissions/

class Solution {
    public int[] findBall(int[][] grid) {
        int ans[] = new int[grid[0].length];
        for(int k = 0; k < ans.length; k++) {
            int i = 0, j = k;
            while(i < grid.length) {
                if((grid[i][j] == 1 && j == grid[0].length - 1) || (grid[i][j] == -1 && j == 0)) break;
                if(grid[i][j] != grid[i][j + grid[i][j]]) break;
                j += grid[i][j];
                i++;
            }
            ans[k] = i > grid.length - 1 ? j : -1;
        }
        
        return ans;
    }
}