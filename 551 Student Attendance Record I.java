// https://leetcode.com/problems/student-attendance-record-i/

class Solution {
    public boolean checkRecord(String s) {
        int x = 0, y = 0;
        for(char c: s.toCharArray()) {
            if(c == 'A') {x++; y = 0;}
            else if(c == 'L') y++;
            else y = 0;
            
            if(x > 1 || y > 2) return false;
        }
        return true;
    }
}