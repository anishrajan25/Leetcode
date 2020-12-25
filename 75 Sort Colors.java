// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for(int i = 0; i <= r; ++i) {
            if(nums[i] == 0) {
                nums[i] = nums[l];
                nums[l++] = 0;
            }
            else if(nums[i] == 2) {
                nums[i--] = nums[r];
                nums[r--] = 2;
            }
            // System.out.println(Arrays.toString(nums) + " " + i + " " + l + " " + r);
        }
    }
}