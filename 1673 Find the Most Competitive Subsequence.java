// https://leetcode.com/problems/find-the-most-competitive-subsequence/

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int res[] = new int[k], ind = 0;
        for(int i = 0; i < nums.length; i++) {
            while(ind > 0 && k - ind < nums.length - i && res[ind - 1] > nums[i]) ind--;
            if(ind < k) res[ind++] = nums[i];
        }
        return res;
    }
}