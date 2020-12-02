// https://leetcode.com/problems/maximum-length-of-pair-chain/

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int m = pairs[0][1], ans = 0;
        for(int i = 1; i < pairs.length; ++i) {
            if(pairs[i][0] <= m) ++ans;
            else m = pairs[i][1];
        }
        return pairs.length - ans;
    }
}