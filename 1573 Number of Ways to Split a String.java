// https://leetcode.com/problems/number-of-ways-to-split-a-string/

class Solution {
    final int MOD = 1000000007;
    public int numWays(String s) {
        char[] inp = s.toCharArray();
        int c = 0;
        for(int i = 0; i < inp.length; i++)
            if(inp[i] == '1') c++;
        
        if(c == 0) return (int)((long)(inp.length - 1) * (long)(inp.length - 2)/2 % MOD) ;
        if(c%3 != 0 || inp.length < 3 ) return 0;
        
        c /= 3;
        
        int i = 0, tc = 0;
        long l = 0, r = 0;
        while(tc != c) {
            if(inp[i] == '1') tc++;
            i++;
        }
        
        while(inp[i] != '1') {
            i++;
            l++;
        }
        tc = 0;
        while(tc != c) {
            if(inp[i] == '1') tc++;
            i++;
        }
        while(inp[i] != '1') {
            i++;
            r++;
        }
        
        return (int)(((l + 1) * (r + 1)) % MOD);
    }
}