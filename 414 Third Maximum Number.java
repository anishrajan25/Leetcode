// https://leetcode.com/problems/third-maximum-number/

class Solution {
    public int thirdMax(int[] nums) {
        int length = nums.length;
        long firstMax, secondMax, thirdMax;
        firstMax = secondMax = thirdMax = Long.MIN_VALUE;
        for(int i = 0; i < length; i += 1) {
            int num = nums[i];
            if(num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if(num > secondMax && num != firstMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if(num > thirdMax && num != firstMax && num != secondMax) {
                thirdMax = num;
            }
        }
        
        return (int)(thirdMax != Long.MIN_VALUE ? thirdMax : firstMax);
    }
}