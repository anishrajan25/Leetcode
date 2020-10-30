// https://leetcode.com/problems/count-all-possible-routes/

class Solution {
    int[][] dp;
    int MOD = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new int[locations.length][fuel + 1];
        for(int[] tmp: dp) Arrays.fill(tmp, -1);
        return helper(locations, start, finish, fuel);
    }
    
    private int helper(int[] loc, int s, int e, int f) {
        if(dp[s][f] != -1) return dp[s][f];
        
        if(s != e && f == 0) return 0;
        
        int ans = s==e ? 1 : 0;
        
        for(int i = 0; i < loc.length; i++) {
            int c = (int)Math.abs(loc[i] - loc[s]);
            if(i == s || c > f) continue;
            ans += helper(loc, i, e, f - c);
            ans %= MOD;
        }
        
        dp[s][f] = ans;
        return ans;
    }
}