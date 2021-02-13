// https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        helper(s.toCharArray(), 0, new LinkedList<String>(), res);
        return res;
    }
    
    private void helper(char[] s, int i, LinkedList<String> l, List<List<String>> res) {
        if(i == s.length) {
            res.add(new ArrayList(l));
            return;
        }
        
        for(int j = i; j < s.length; j++) {
            if(isPalindrome(s, i, j)) {
                l.addLast(new String(s, i, j - i + 1));
                helper(s, j + 1, l, res);
                l.removeLast();
            }
        }
    }
    
    private boolean isPalindrome(char[] s, int l, int r) {
        while(l < r) {
            if(s[l++] != s[r--]) return false;
        }
        
        return true;
    }
}