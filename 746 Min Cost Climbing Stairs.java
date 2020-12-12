// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0], cost[1]);
        int prev1 = 0, prev2 = 0;
        for(int i = 0; i < cost.length; ++i) {
            int t = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = t;
        }
        return Math.min(prev1, prev2);
    }
}