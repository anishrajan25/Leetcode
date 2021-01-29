// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
    public int removeDuplicates(int[] nums) {
        int r = 0, w = 0;
        while(r < nums.length) {
            int c = 1;
            while(r < nums.length - 1 && nums[r] == nums[r + 1]) {
                r++;
                c++;
            }
            c = Math.min(c, 2);
            while(c-- > 0) nums[w++] = nums[r];
            r++;
        }
        return w;
    }
}