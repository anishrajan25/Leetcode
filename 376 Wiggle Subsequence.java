// https://leetcode.com/problems/wiggle-subsequence/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        int gt = 0;
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1] && gt != -1) {
                gt = -1;
                res++;
            } else if(nums[i] < nums[i-1] && gt != 1) {
                gt = 1;
                res++;
            }
        }
        
        return res;
    }
}