// https://leetcode.com/problems/next-greater-element-ii/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length], st[] = new int[nums.length];
        int k = -1;
        for(int i = 0; i < nums.length; i++) {
            while(k > -1 && nums[st[k]] < nums[i]) res[st[k--]] = nums[i];
            st[++k] = i;
        }
        for(int i = 0; k > -1 && i < st[k]; i++) {
            while(k > -1 && nums[st[k]] < nums[i]) res[st[k--]] = nums[i];
        }
        while(k > -1) res[st[k--]] = -1;
        
        return res;
    }
}