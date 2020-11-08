// https://leetcode.com/problems/crawler-log-folder/

class Solution {
    public int minOperations(String[] logs) {
        Stack<String> dir = new Stack();
        for(String op: logs) {
            if(op.equals("../")) {if(!dir.isEmpty()) dir.pop();}
            else if(op.equals("./")) continue;
            else dir.push(op);
        }
        
        return dir.size();
    }
}