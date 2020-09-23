// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int med = nums[nums.length/2];
        int res = 0;
        for(int i: nums) res += (int)Math.abs(med - i);
        
        return res;
    }
}