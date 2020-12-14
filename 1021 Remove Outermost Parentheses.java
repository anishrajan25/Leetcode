// https://leetcode.com/problems/remove-outermost-parentheses/

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int o = 0, s = 0;
        for(char c: S.toCharArray()) {
            if(c == '(') {
                sb.append(c);
                o++;
            } else if(c == ')') {
                o--;
                if(o == 0) {
                    sb.deleteCharAt(s);
                    s = sb.length();
                }
                else sb.append(c);
            }
        }
        
        return sb.toString();
    }
}