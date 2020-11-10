// https://leetcode.com/problems/construct-k-palindrome-strings/

class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()) return false;
        if(k == s.length() || k >= 26) return true;
        
        int[] cnt = new int[26];
        for(char c: s.toCharArray()) {
            if((++cnt[c - 97] & 1) == 1) k--;
            else k++;
        }
        
        return k >= 0;
    }
}