// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/


// solution is pretty simple and straight forward
// first we count the frequency of each char in the string
// then we put each char of the string in the string res(the string that we'll be returning)
// if we find a char x (in text) that is smaller than the last char in our res string
// then we remove the char from the end of the res string
// then we will add the char x at the end of our res string
// this will ensure that the res will be lexicographically smallest subsequence of text

class Solution {
    public String smallestSubsequence(String text) {
        int n = text.length();
        int[] freq = new int[26];
        boolean[] taken = new boolean[26];
        int i = 0, len = 0;
        
        for(char c: text.toCharArray()) freq[c - 'a']++;
        
        StringBuilder res = new StringBuilder();
        res.append('0');
        
        for(char c: text.toCharArray()) {
            freq[c-'a']--;
            if(!taken[c - 'a']) {
                while(res.charAt(res.length() - 1) > c && freq[res.charAt(res.length() - 1) - 'a'] > 0) {
                    taken[res.charAt(res.length() - 1) - 'a'] = false;
                    res.deleteCharAt(res.length() - 1);
                }
                res.append(c);
                taken[c-'a'] = true;
            }
        }
        
        return res.substring(1).toString();
    }
}