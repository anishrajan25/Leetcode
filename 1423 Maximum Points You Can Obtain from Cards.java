// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0, l = k - 1, r = cardPoints.length - 1;
        for(int i = 0; i < k; ans += cardPoints[i++]);
        if(k >= cardPoints.length) return ans;
        int tmp = ans;
        while(l >= 0) {
            tmp = tmp - cardPoints[l--] + cardPoints[r--];
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}