// https://leetcode.com/problems/house-robber-ii/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(check(nums, 0, nums.length - 2), check(nums, 1, nums.length - 1));
    }
    
    private int check(int[] nums, int s, int e) {
        int prev1 = 0, prev2 = 0;
        while(s <= e) {
            int t = prev1;
            prev1 = Math.max(prev2 + nums[s++], prev1);
            prev2 = t;
        }
        
        return prev1;
    }
}