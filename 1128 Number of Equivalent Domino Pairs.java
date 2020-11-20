// https://leetcode.com/problems/number-of-equivalent-domino-pairs/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        Map<Integer, Integer> hm = new HashMap();
        for(int[] d: dominoes) {
            int x = Math.min(d[0], d[1]) * 10  + Math.max(d[1], d[0]);
            if(!hm.containsKey(x)) hm.put(x, 0);
            int t = hm.get(x);
            hm.put(x, t + 1);
            ans += t;
        }
        
        return ans;
    }
}