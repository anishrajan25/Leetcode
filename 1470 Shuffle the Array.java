// https://leetcode.com/problems/shuffle-the-array/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int k = 0, i = 0;
        while(k < nums.length) {
            if((k & 1) == 0) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[n++];
            }
        }
        
        return res;
    } 
}