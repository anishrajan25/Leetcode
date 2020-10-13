// https://leetcode.com/problems/word-search/

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == w[0] && dfs(board, w, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] b, char[] w, int i, int j, int pos) {
        if(pos >= w.length) return true;
        if(i < 0 || i >= b.length || j < 0 || j >= b[0].length || b[i][j] != w[pos]) return false;
        b[i][j] = '-';
        pos++;
        if(dfs(b, w, i, j + 1, pos)) return true;
        if(dfs(b, w, i + 1, j, pos)) return true;
        if(dfs(b, w, i, j - 1, pos)) return true;
        if(dfs(b, w, i - 1, j, pos)) return true;
        b[i][j] = w[--pos];
        return false;
    }
}