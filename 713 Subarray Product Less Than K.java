// https://leetcode.com/problems/subarray-product-less-than-k/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int res = 0, prod = 1;
        int l = 0, r = 0;
        while(l <= r && r < nums.length) {
            prod *= nums[r];
            while(prod >= k) prod /= nums[l++];
            res += r - l + 1;
            r++;
        }
        return res;
    }
}