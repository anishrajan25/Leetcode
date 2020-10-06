// https://leetcode.com/problems/queens-that-can-attack-the-king/

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] diag = new int[][]{{Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                                  {Integer.MAX_VALUE, Integer.MIN_VALUE, -1},
                                  {Integer.MIN_VALUE, Integer.MAX_VALUE, -1},
                                  {Integer.MIN_VALUE, Integer.MIN_VALUE, -1}};
        int[] dr = new int[]{Integer.MAX_VALUE, -1, Integer.MIN_VALUE, -1}, dc = new int[]{Integer.MAX_VALUE, -1, Integer.MIN_VALUE, -1};
        
        for(int i = 0; i<queens.length; ++i) {
            int r = king[0] - queens[i][0];
            int c = king[1] - queens[i][1];
            // same row
            if(r == 0) {
                // left of king
                if(c > 0 && c < dc[0]) {
                    dc[0] = c;
                    dc[1] = i;
                }
                // right of king
                else if(c < 0 && c > dc[2]) {
                    dc[2] = c;
                    dc[3] = i;
                }
            }
            // same col
            else if(c == 0) {
                // left of king
                if(r > 0 && r < dr[0]) {
                    dr[0] = r;
                    dr[1] = i;
                }
                // right of king
                else if(r < 0 && r > dr[2]) {
                    dr[2] = r;
                    dr[3] = i;
                }
            }
            if(Math.abs(r) != Math.abs(c)) continue;
            // check for diagonals
            else {
                // diagonals above king
                if(r > 0) {
                    // top left diagonal
                    if(c > 0 && c < diag[0][1] && r <= diag[0][0]) {
                        diag[0][0] = r;
                        diag[0][1] = c;
                        diag[0][2] = i;
                    }
                    // top right diagonal
                    else if(c < 0 && c > diag[1][1] && r <= diag[1][0]) {
                        diag[1][0] = r;
                        diag[1][1] = c;
                        diag[1][2] = i;
                    }
                }
                // diagonals below king
                else {
                    // lower left diagonal
                    if(c > 0 && c < diag[2][1] && r >= diag[2][0]) {
                        diag[2][0] = r;
                        diag[2][1] = c;
                        diag[2][2] = i;
                    }
                    else if(c < 0 && c > diag[3][1] && r >= diag[3][0]) {
                        diag[3][0] = r;
                        diag[3][1] = c;
                        diag[3][2] = i;
                    }
                }
            }
        }
        
        LinkedList<List<Integer>> res = new LinkedList();
        LinkedList<Integer> q = new LinkedList();
        check(dr[1], new LinkedList<Integer>(), res, queens);
        check(dr[3], new LinkedList<Integer>(), res, queens);
        check(dc[1], new LinkedList<Integer>(), res, queens);
        check(dc[3], new LinkedList<Integer>(), res, queens);
        
        for(int i = 0; i<4; i++) {
            check(diag[i][2], new LinkedList<Integer>(), res, queens);
        }
        
        return res;
    }
    
    private void check(int i, List<Integer> q, List<List<Integer>> res, int[][] queens) {
        if(i != -1) {
            q.add(queens[i][0]);
            q.add(queens[i][1]);
            res.add(q);
        }
    }
}