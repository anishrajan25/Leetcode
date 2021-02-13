// https://leetcode.com/problems/word-break/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s.toCharArray(), 0, wordDict, new boolean[s.length()]);
    }
    
    private boolean helper(char[] s, int b, List<String> arr, boolean[] checked) {
        if(b == s.length) return true;
        if(checked[b]) return false;
        
        StringBuilder sb = new StringBuilder();
        for(int i = b; i < s.length; i++) {
            sb.append(s[i]);
            if(arr.contains(sb.toString()) && helper(s, i + 1, arr, checked)) return true;
        }
        
        checked[b] = true;
        return false;
    }
}