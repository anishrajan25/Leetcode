// https://leetcode.com/problems/remove-duplicate-letters/


// solution is pretty simple and straight forward
// first we count the frequency of each char in the string
// then we put each char of the string in the string res(the string that we'll be returning)
// if we find a char c (in text) that is smaller than the last char in our res string
// then we remove the char from the end of the res string
// then we will add the char c at the end of our res string
// this will ensure that the res will be lexicographically smallest subsequence of text

class Solution {
    public String removeDuplicateLetters(String text) {
        int[] cnt = new int[26];
        boolean[] added = new boolean[26];
        
        for(char c: text.toCharArray()) cnt[c - 'a']++;
        
        StringBuilder res = new StringBuilder();
        res.append('0');
        
        for(char c: text.toCharArray()) {
            cnt[c-'a']--;
            if(!added[c - 'a']) {
                char x = res.charAt(res.length() - 1); 
                while(x > c && cnt[x - 'a'] > 0) {
                    res.deleteCharAt(res.length() - 1);
                    added[x - 'a'] = false;
                    x = res.charAt(res.length() - 1);
                }
                res.append(c);
                added[c-'a'] = true;
            }
        }
        
        return res.substring(1).toString();
    }
}