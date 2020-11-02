// https://leetcode.com/problems/out-of-boundary-paths/

class Solution {
    int r, c;
    int[][] memo;
    int MOD = 1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        memo = new int[m*n][N+1];
        r = m;
        c = n;
        for(int[] t: memo) Arrays.fill(t, -1);
        return dfs(N, i, j);
    }
    
    public int dfs(int N, int i, int j) {
        if(i == r || j == c || i < 0 || j < 0) return 1;
        if(N == 0) return 0;
        if(memo[i*c + j][N] >= 0) return memo[i*c + j][N];
        
        return memo[i*c + j][N] = ((dfs(N - 1, i - 1, j)  + dfs(N - 1, i + 1, j)) % MOD + (dfs(N - 1, i, j - 1) + dfs(N - 1, i, j + 1)) % MOD) % MOD;
    }
}