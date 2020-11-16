// https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; ++i) {
            int c = 1;
            while(i < nums.length - 1) {
                if(nums[i + 1] == nums[i] + 1) c++;
                else if (nums[i + 1] > nums[i] + 1) break;
                ++i;
            }
            ans = Math.max(ans, c);
            if(ans > nums.length - i) break;
        }
        
        return ans;
    }
}