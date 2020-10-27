// https://leetcode.com/problems/letter-case-permutation/

class Solution {
    ArrayList<String> res;
    char[] ip;
    public List<String> letterCasePermutation(String S) {
        res = new ArrayList();
        ip = S.toCharArray();
        backtrack(0);
        return res;
    }
    
    private void backtrack(int i) {
        if(i == ip.length){
            res.add(new String(ip));
            return;
        }
        if(ip[i] >= '0' && ip[i] <= '9') backtrack(i+1);
        else {
            ip[i] = Character.toUpperCase(ip[i]);
            backtrack(i + 1);
            ip[i] = Character.toLowerCase(ip[i]);
            backtrack(i + 1);
        }
    }
}