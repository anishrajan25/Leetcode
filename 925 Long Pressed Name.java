// https://leetcode.com/problems/long-pressed-name/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) return false;
        char[] n = name.toCharArray(), t = typed.toCharArray();
        
        int i = 0, j = 0;
        while(i < n.length && j < t.length) {
            int c1 = 0, c2 = 0;
            if(n[i] != t[j]) return false;
            while(i < n.length - 1 && n[i] == n[i + 1]) {
                c1++;
                i++;
            }
            while(j < t.length - 1 && t[j] == t[j + 1]) {
                c2++;
                j++;
            }
            if(c2 < c1) return false;
            i++;
            j++;
        }
        
        return i == n.length && j == t.length;
    }
}