// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] nums) {
        int m = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; m = Math.min(m, nums[i++]));
        return m;
    }
}
