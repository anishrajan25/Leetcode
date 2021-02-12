// https://leetcode.com/problems/max-number-of-k-sum-pairs/

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int t = nums[l] + nums[r];
            if(t > k) r--;
            else if(t < k) l++;
            else {
                res++;
                l++;
                r--;
            }
        }
        return res;
    }
}