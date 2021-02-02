// https://leetcode.com/problems/find-right-interval/

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] arr = new int[intervals.length][3];
        for(int i = 0; i < intervals.length; i++) arr[i] = new int[]{intervals[i][0], intervals[i][1], i};
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        int res[] = new int[intervals.length];
        
        for(int i = 0; i < arr.length; i++) {
            int x = i + 1, r = arr.length - 1;
            while(x < r) {
                int m = (r + x) / 2;
                if(arr[m][0] < arr[i][1]) x = m + 1;
                else r = m;
            }
            res[arr[i][2]] = x == arr.length || arr[x][0] < arr[i][1] ? -1 : arr[x][2];
        }
        
        return res;
    }
}