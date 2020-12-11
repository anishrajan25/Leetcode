// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

class Solution {
    public int minSteps(String s, String t) {
        int ans = 0;
        int[] f = new int[26];
        for(char c: s.toCharArray()) f[c - 'a']++;
        for(char c: t.toCharArray()) if(--f[c - 'a'] < 0) ++ans;
        return ans;
    }
}