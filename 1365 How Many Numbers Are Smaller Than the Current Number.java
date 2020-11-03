// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for(int num: nums)
            count[num]++;
        int sum = 0; // store count of elements smaller than curr el
        for(int i = 0; i < 101; i++){
            if(count[i] > 0) {
                int t = count[i]; // count of curr el
                count[i] = sum;
                sum += t; // count of els smaller than next el
            }
        }
        
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = count[nums[i]];
        }
        
        return result;
    }
}