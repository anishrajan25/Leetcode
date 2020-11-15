// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

class Solution {
    public int minAddToMakeValid(String S) {
        int res = 0, op = 0;
        for(char c: S.toCharArray()) {
            if(c == ')') {
                if(op > 0) op--;
                else res++;
            } else op++;
        }
        
        return res + op;
    }
}