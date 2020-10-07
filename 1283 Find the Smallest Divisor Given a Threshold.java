// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[nums.length - 1];
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (check(nums, threshold, middle))
                right = middle;
            else 
                left = middle + 1;
        }
        return left;
    } 
    public boolean check(int [] nums, int threshold, int middle) {
        int sum = 0;
        for (int x: nums) {
            sum += (x-1) / middle + 1;
        }
        return sum <= threshold;
    }
}