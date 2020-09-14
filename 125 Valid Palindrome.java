class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()<=1)return true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            char c = s.charAt(left);
            if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                left++; 
                continue;
            }
            char r = s.charAt(right);
            if(!((r >= 'A' && r <= 'Z') || (r >= 'a' && r <= 'z') || (r >= '0' && r <= '9'))) {
                right--; 
                continue;
            }
        
            if(!equal(c, r)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
    private boolean equal(char c, char r) {
            if(c > 'Z' && r > 'Z') {
                return c == r;
            } else if(c > 'Z') {
                return c - 'a' == r - 'A';
            } else if(r > 'Z') {
                return c - 'A' == r - 'a';
            } else {
                return c == r;
            }
    }
}