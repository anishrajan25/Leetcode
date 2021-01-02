// https://leetcode.com/problems/license-key-formatting/

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] s = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for(int i = s.length - 1; i > -1; --i) {
            if(s[i] == '-') continue;
            if(s[i] >= 'a' && s[i] <= 'z') sb.append((char)(s[i] - 32));
            else sb.append(s[i]);
            t++;
            if(t == K && i != 0) {
                t = 0;
                sb.append('-');
            }
        }
        if(sb.length() == 0) return "";
        sb.reverse();
        t = 0;
        while(sb.charAt(t) == '-') t++;
        return t == 0 ? sb.toString() : sb.toString().substring(t);
    }
}