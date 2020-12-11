// https://leetcode.com/problems/water-bottles/

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles < numExchange) return numBottles;
        int ans = 0, rem = 0;
        while(numBottles != 0) {
            ans += numBottles;
            int t = (numBottles + rem) / numExchange;
            rem = (numBottles + rem) % numExchange;
            numBottles = t;
        }
        
        return ans;
    }
}