// https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String S, int k) {
        char[] str = S.toCharArray();
        int c[] = new int[26], p[][] = new int[26][2];
        int ans = 0;
        for(int i = 0; i < str.length; i++) {
            if(c[str[i] - 'A']++ == 0) p[str[i] - 'A'][0] = i;
            else p[str[i] - 'A'][1] = i;
        }
        
        for(int i = 0; i < 26; i++) {
            if(c[i] == 0) continue;
            if((p[i][1] - p[i][0] - c[i] - k + 1) < 0) {
                ans = Math.max(ans, Math.min(str.length, c[i] + k));
                continue;
            }
            int s = p[i][0], e = p[i][0], t = k;
            char ch = (char)(i + 'A');
            while(e <= p[i][1]) {
                if(str[e] != ch) {
                    if(k > 0) {
                        k--;
                    }
                    else {
                        while(s < e) {
                            if(str[s] != ch) {
                                s++;
                                break;
                            }
                            s++;
                        }
                        if(s == e) s++;
                    }
                }
                ans = Math.max(ans, e++ - s + 1);
            }
            k = t;
        }
        
        return ans;
    }
}