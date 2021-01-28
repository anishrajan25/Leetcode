// https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        while(i < arr.length - 1 && arr[i] < arr[i + 1]) i++;
        return i;
    }
}