// https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length < 2 || k % nums.length == 0) return;
        k %= nums.length;
        rev(nums, 0, nums.length - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, nums.length - 1);
    }
    
    public void rev(int[] nums, int l, int r) {
        while(l < r) {
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
    }
}