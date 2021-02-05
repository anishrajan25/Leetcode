// https://leetcode.com/problems/determine-if-string-halves-are-alike/

class Solution {
    public boolean halvesAreAlike(String s) {
        char[] str = s.toCharArray();
        int l = 0, r = str.length - 1, lc = 0, rc = 0;
        while(l < r) {
            if(isVowel(str[l++])) lc++;
            if(isVowel(str[r--])) rc++;
        }
        return lc == rc;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}