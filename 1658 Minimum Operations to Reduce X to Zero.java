// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

class Solution {
    public int minOperations(int[] nums, int x) {
        if(nums[0] > x && nums[nums.length - 1] > x) return -1;
        if(nums[0] == x || nums[nums.length - 1] == x) return 1;
        
        int sum = 0;
        for(int i: nums) sum += i;
        sum -= x;
        if(sum < 0) return -1;
        if(sum == 0) return nums.length;
        int start = 0, cur = 0, len = -1;
        for(int end = 0; end < nums.length; end++)
        {
            if (cur < sum)
                cur += nums[end];
            while (cur >= sum) {
                if (cur == sum)
                    len = Math.max(len, end - start + 1);
                cur -= nums[start++];
            }
        }

        return len == -1 ? -1 : nums.length - len;
    }
}