// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for(int n: nums) sum += n;
        
        int lsum = 0, n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = (nums[i] * i) - lsum + sum - (nums[i] * (n - i));
            lsum += nums[i];
            sum -= nums[i];
        }
        
        return res;
    }
}