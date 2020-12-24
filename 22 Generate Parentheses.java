// https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        helper(0, 0, 0, new char[2*n], res);
        return res;
    }
    
    private void helper(int o, int c, int s, char[] ch, List<String> res) {
        if(o == ch.length / 2) {
            while(s < ch.length) ch[s++] = ')';
            res.add(new String(ch));
            return;
        }
        
        if(o < ch.length / 2) {
            ch[s] = '(';
            helper(o + 1, c, s + 1, ch, res);
        }
        if(c < o) {
            ch[s] = ')';
            helper(o, c + 1, s + 1, ch, res);
        }
    }
}