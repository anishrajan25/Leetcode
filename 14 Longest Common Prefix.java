// https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length() && i < strs[1].length(); ++i) {
            if(strs[0].charAt(i) == strs[1].charAt(i)) sb.append(strs[0].charAt(i));
            else break;
        }
        
        char[] res = sb.toString().toCharArray();
        int l = res.length;
        for(int i = 2; i < strs.length; i++) {
            int j = 0;
            char str[] = strs[i].toCharArray();
            while(j < str.length && j < l) {
                if(str[j] != res[j]) break;
                j++;
            }
            l = j;
        }
        
        return new String(res, 0, l);
    }
}