class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] cubeFlag = new boolean[9][9];
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                if (rowFlag[i][c] || colFlag[j][c] || cubeFlag[3 * (i / 3) + j / 3][c]) {
                    return false;
                }
                rowFlag[i][c] = true;
                colFlag[j][c] = true;
                cubeFlag[3 * (i / 3) + j / 3][c] = true;
            }
        }
        return true;
    }
}