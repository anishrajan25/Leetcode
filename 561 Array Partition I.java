// https://leetcode.com/problems/array-partition-i/

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.parallelSort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; ans += nums[i], i += 2);
        return ans;
    }
}