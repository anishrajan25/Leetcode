// https://leetcode.com/problems/rotate-string/


class Solution {
    public boolean rotateString(String A, String B) {
        int n = A.length();
        int m = B.length();
        if(n!=m) return false;
        if(A.equals(B)) return true;
        
        int x = B.indexOf(A.charAt(0));
        int i = 1, j = x + 1;
        while(x != -1) {
            if(i < n && A.charAt(i) == B.charAt(j)) {
                ++i;++j;
                if(j == m) j = 0;
            }
            else{
                x = B.indexOf(A.charAt(0), x+1);
                i = 1;
                j = x+1;
                if(j == m) j = 0;
            }
            if(j == x) return true;
        }
        return false;
    }
}