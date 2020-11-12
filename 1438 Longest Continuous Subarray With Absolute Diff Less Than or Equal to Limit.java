// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0, min_i = 0, max_i = 0, res = 0;
        while(r < nums.length) {
            if(nums[r] <= nums[min_i]) min_i = r;
            if(nums[r] >= nums[max_i]) max_i = r;
            if(nums[max_i] - nums[min_i] > limit) {
                res = Math.max(res, r - l);
                if (res - 1 > nums.length - r) break;
                l = r = (max_i < min_i ? max_i : min_i) + 1;
                min_i = max_i = l;
                continue;
            }
            r++;
        }
        res = Math.max(res, r - l);
        return res;
    }
}