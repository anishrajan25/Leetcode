// https://leetcode.com/problems/custom-sort-string/

class Solution {
    public String customSortString(String S, String T) {
        int[] freq = new int[26];
        
        for(char c: T.toCharArray()) freq[c - 'a']++;
        
        StringBuilder res = new StringBuilder();
        
        for(char c: S.toCharArray()) {
            while(freq[c - 'a']-- > 0) res.append(c);
        }
        
        for(int i = 0; i < 26; ++i) while(freq[i]-- > 0) res.append((char)(i + 'a'));
        
        return res.toString();
    }
}