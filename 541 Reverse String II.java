// https://leetcode.com/problems/reverse-string-ii/

class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder(), tmp = new StringBuilder();
        int tk = 0;
        boolean rev = true;
        for(char c: s.toCharArray()) {
            tmp.append(c);
            tk++;
            if(tk == k) {
                if(rev) tmp.reverse();
                res.append(tmp);
                tmp = new StringBuilder();
                rev = !rev;
                tk = 0;
            }
        }
        
        if(tmp.length() != 0) {
            if(rev) tmp.reverse();
            res.append(tmp);
        }
        return res.toString();
    }
}