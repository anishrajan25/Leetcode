// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/

class Solution {
    public boolean queryString(String S, int N) {
        for(int i = 1; i <= N; i++) {
            if(S.indexOf(Integer.toBinaryString(i)) == -1) return false;
        }
        
        return true;
    }
}