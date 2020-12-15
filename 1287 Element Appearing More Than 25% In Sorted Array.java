// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int m = (int)arr.length / 4 + 1;
        for(int i = 0; i < arr.length; i += m) {
            int c = 1, j = i - 1;
            while(j >= 0 && arr[j] == arr[i]) {
                j--;
                c++;
            }
            j = i + 1;
            while(j < arr.length && arr[j] == arr[i]) {
                j++;
                c++;
            }
            if(c >= m) return arr[i];
        }
        
        return -1;
    }
}