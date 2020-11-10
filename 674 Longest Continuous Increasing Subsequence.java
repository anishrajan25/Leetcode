// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        int c = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i;
            while(i < nums.length - 1 && nums[i+1] > nums[i]) i++;
            c = Math.max(c, i - j + 1);
        }
        return c;
    }
}