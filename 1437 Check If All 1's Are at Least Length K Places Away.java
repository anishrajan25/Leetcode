// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int a = -1, i = 0;
        while(i < nums.length && nums[i] != 1) i++;
        a = i++;
        for(i = i; i < nums.length; ++i) {
            if(nums[i] == 1) {
                if(k >= i - a) return false;
                a = i;
            }
        }
        return true;
    }
}