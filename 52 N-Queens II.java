// https://leetcode.com/problems/n-queens-ii/

class Solution {
  int rows[];
  int hills[];
  int dales[];
  int n;
    
  int res;

  int queens[];

  public boolean isNotUnderAttack(int row, int col) {
    return rows[col] + hills[row - col + n - 1] + dales[row + col] == 0;
  }

  public void placeQueen(int row, int col) {
    queens[row] = col;
    rows[col] = 1;
    hills[row - col + n - 1] = 1;
    dales[row + col] = 1;
  }

  public void removeQueen(int row, int col) {
    queens[row] = 0;
    rows[col] = 0;
    hills[row - col + n - 1] = 0;
    dales[row + col] = 0;
  }

  public void backtrack(int row) {
    if(row == n) {
        res++;
        return;
    }
    for (int col = 0; col < n; col++) {
      if (isNotUnderAttack(row, col)) {
        placeQueen(row, col);
        
        backtrack(row + 1);
        
        removeQueen(row, col);
      }
    }
  }

  public int totalNQueens(int n) {
    this.n = n;
    rows = new int[n];
    hills = new int[2 * n - 1];
    dales = new int[2 * n - 1];
    queens = new int[n];
    res = 0;

    backtrack(0);
    
    return res;
  }
}