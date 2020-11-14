// https://leetcode.com/problems/bag-of-tokens/

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        if(tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int s = tokens[0] <= P ? 1 : 0;
        if(s == 0) return 0;
        int res = s, l = s, r = tokens.length - 1;
        P -= tokens[0];

        while(l <= r) {
            if(tokens[l] <= P) {
                P -= tokens[l++];
                s++;
                res = Math.max(res, s);
            }
            else if(s > 0){
                P += tokens[r--];
                s--;
            }
            else break;
        }
        
        return res;
    }
}