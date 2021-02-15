// https://leetcode.com/problems/goal-parser-interpretation/submissions/

class Solution {
    public String interpret(String cmd) {
        return cmd.replace("()", "o").replace("(al)", "al");
    }
}