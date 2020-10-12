// https://leetcode.com/problems/three-consecutive-odds/

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) return false;
        
        int i = 0;
        while(i < arr.length - 3 + 1) {
            if(arr[i]%2 == 1 && arr[i+1]%2 == 1 && arr[i+2]%2 == 1)
                return true;
            ++i;
        }
        
        return false;
    }
}