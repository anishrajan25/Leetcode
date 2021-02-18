// https://leetcode.com/problems/swap-for-longest-repeated-character-substring/

class Solution {
    public int maxRepOpt1(String text) {
        int ans = -1, arr[] = new int[26], diff = 0;
        char[] t = text.toCharArray();
        HashSet<Character> hs = new HashSet();
        for(char c: t) if(++arr[c - 'a'] == 1) hs.add(c);
        
        for(char c : hs){
            if(arr[c - 'a'] <= ans) continue;
            int l = 0;
            for(int i = 0; i < t.length; ++i) {
                boolean swap = true;
                l = 0;
                while(i < t.length && t[i] == c) {
                    i++;l++;
                }
                i++;
                int tmp = i;
                while(i < t.length && t[i] == c) {
                    i++;l++;
                }
                if(l < arr[c - 'a']) swap = false;
                i = --tmp;
                ans = Math.max(ans, !swap ? 1 + l : l);
            }
            ans = Math.max(ans, l);
        }
        
        return ans;
    }
}