// https://leetcode.com/problems/jump-game-ii/

class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        if(nums[0] >= nums.length - 1) return 1;
        int i = 0, c = 1;
        while(i < nums.length - 1) {
            if(i + nums[i] >= nums.length - 1) return c;
            int end = Math.min(nums.length - 2, i + nums[i]), mi = ++i;
            i++;
            while(i <= end) {
                if(mi + nums[mi] <= i + nums[i]) mi = i;
                i++;
            }
            c++;
            i = mi;
        }
        
        return c;
    }
}