// https://leetcode.com/problems/path-with-maximum-gold/


class Solution {
    public int getMaximumGold(int[][] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0) continue;
                max = Math.max(max, helper(arr, i, j));
            }
        }
        
        return max;
    }
    
    public static int helper(int[][] arr, int row, int col){
        if(row < 0 || col < 0 || row == arr.length || col == arr[0].length || arr[row][col] == 0) return 0;
        
        int gold = arr[row][col];
        
        arr[row][col] = 0;
        
        int max = Math.max(helper(arr, row-1, col), Math.max(helper(arr, row+1, col), Math.max(helper(arr, row, col+1), helper(arr, row, col-1))));
        
        arr[row][col] = gold;
        
        return gold + max;
    }
}