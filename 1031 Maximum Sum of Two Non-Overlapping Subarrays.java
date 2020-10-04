// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

class Solution {
    int dp[];
    private int helper(int[] A, int L, int M) {
        int first = 0, max = 0 ;
        for(int i = 0; i + L + M < dp.length ; ++i) {
            first = Math.max(first, dp[i + L] - dp[i]);
            max = Math.max(max, first + dp[i + L + M] - dp[i + L]);
        }
        return max;
    }
    
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if(A.length == 0) return 0;
        dp = new int[A.length + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; ++i) dp[i] = A[i-1] + dp[i-1];
        
        return Math.max(helper(A, L, M), helper(A, M, L));
    }
}