// https://leetcode.com/problems/jump-game-iii/

class Solution {
    public boolean canReach(int[] arr, int start) {
        return helper(arr, start, new boolean[arr.length]);
    }
    
    private boolean helper(int[] arr, int i, boolean[] v) {
        if(i < 0 || i >= arr.length || v[i]) return false;
        if(arr[i] == 0) return true;
        v[i] = true;
        return helper(arr, i + arr[i], v) || helper(arr, i - arr[i], v);
    }
}