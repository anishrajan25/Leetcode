// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList();
        if(digits == null || digits.length() == 0) return ans;
        char[][] map = new char[8][];
        
        map[0] = "abc".toCharArray();
        map[1] = "def".toCharArray();
        map[2] = "ghi".toCharArray();
        map[3] = "jkl".toCharArray();
        map[4] = "mno".toCharArray();
        map[5] = "pqrs".toCharArray();
        map[6] = "tuv".toCharArray();
        map[7] = "wxyz".toCharArray();
        
        ans.add("");
        for(char c: digits.toCharArray()) {
            ans = eval(ans, map[c - '2']);
        }
        
        return ans;
    }
    
    private List<String> eval(List<String> l, char[] ch) {
        LinkedList<String> ans = new LinkedList();
        for(String s: l)
            for(char c: ch)
                ans.addLast(s + c);
        
        return ans;
    }
}