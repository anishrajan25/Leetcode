// https://leetcode.com/problems/increasing-triplet-subsequence/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 2) return false;
        int l = Integer.MAX_VALUE, m = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= l) l = nums[i];
            else if(nums[i] <= m) m = nums[i];
            else return true;
        }
        
        return false;
    }
}