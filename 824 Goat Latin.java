// https://leetcode.com/problems/goat-latin/

class Solution {
    public String toGoatLatin(String S) {
        String[] w = S.split("\\s+");
        StringBuilder sb = new StringBuilder("a");
        for(int i = 0; i < w.length; ++i) {
            if(isVowel(w[i].charAt(0))) {
                w[i] += "ma" + sb.toString();
            }
            else {
                w[i] = w[i].substring(1) + w[i].charAt(0) + "ma" + sb.toString();
            }
            sb.append("a");
        }
        
        sb = new StringBuilder();
        for(String s: w) sb.append(s).append(" ");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'U' || c == 'u';
    }
}