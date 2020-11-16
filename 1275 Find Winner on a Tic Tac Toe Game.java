// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for(int i = 0; i < moves.length; ++i) {
            board[moves[i][0]][moves[i][1]] = (i & 1) + 1;
            if(board[moves[i][0]][moves[i][1]] == board[(moves[i][0] + 1) % 3][moves[i][1]] && board[moves[i][0]][moves[i][1]] == board[(moves[i][0] + 2) % 3][moves[i][1]]) return board[moves[i][0]][moves[i][1]] == 1 ? "A" : "B";
            
            if(board[moves[i][0]][moves[i][1]] == board[moves[i][0]][(moves[i][1] + 1) % 3] && board[moves[i][0]][moves[i][1]] == board[moves[i][0]][(moves[i][1] + 2) % 3]) return board[moves[i][0]][moves[i][1]] == 1 ? "A" : "B";
            
            if(moves[i][0] == moves[i][1] && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[1][1] == 1 ? "A" : "B";
            
            if(moves[i][0] + moves[i][1] == 2 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[1][1] == 1 ? "A" : "B";
        }
        
        if(moves.length == 9) return "Draw";
        
        return "Pending";
    }
}