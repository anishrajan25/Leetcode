// https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int l = 0, r = str.length - 1;
        while(l < r) {
            while(l < r && !isVowel(str[l])) l++;
            while(r > l && !isVowel(str[r])) r--;
            char t = str[l];
            str[l] = str[r];
            str[r] = t;
            l++;
            r--;
        }
        
        return new String(str);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}