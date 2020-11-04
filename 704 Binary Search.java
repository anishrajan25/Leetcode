// https://leetcode.com/problems/binary-search/


class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) return m;
            if(nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return nums[l] == target ? l : -1;
    }
}