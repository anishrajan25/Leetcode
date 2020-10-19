// https://leetcode.com/problems/combination-sum-iv/


class Solution {
    public int combinationSum4(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates.length == 0 || candidates[0] > target) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++)
            for(int j = 0; j < candidates.length; j++)
                if(candidates[j] <= i) dp[i] += dp[i - candidates[j]];
                else break;
        
        return dp[target];
    }
}