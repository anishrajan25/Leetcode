// https://leetcode.com/problems/number-of-substrings-with-only-1s/

class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        char[] str = s.toCharArray();
        int ans = 0;
        int l = 0, r = 0;
        while(r < s.length()) {
            if(str[r] == '0') l = r+1;
            else ans = (ans + r - l + 1) % mod;
            r++;
        }
        
        return ans % mod;
    }
}