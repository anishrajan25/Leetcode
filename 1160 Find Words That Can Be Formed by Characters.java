// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] f = new int[26];
        int ans = 0;
        for(char c: chars.toCharArray()) f[c - 'a']++;
        for(String s: words) {
            int[] tm = Arrays.copyOf(f, f.length);
            boolean add = true;
            for(char c: s.toCharArray()) {
                if(tm[c - 'a']-- == 0) {add = false; break;}
            }
            if(add) ans += s.length();
        }
        
        return ans;
    }
}
