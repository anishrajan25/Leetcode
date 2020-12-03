// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        boolean left = true, right = true;
        int l = 0, r = nums.length - 1;
        while((left || right) && l < r) {
            if(left)
                if(nums[l] == tmp[l]) l++;
                else left = false;
            if(right)
                if(nums[r] == tmp[r]) r--;
                else right = false;
        }
        return l < r ? r - l + 1 : 0;
    }
}