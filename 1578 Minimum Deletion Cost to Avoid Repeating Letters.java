// https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/

class Solution {
    public int minCost(String s, int[] cost) {
        int res = 0, len = s.length();
        char str[] = s.toCharArray();
        for(int i = 0; i < len-1; ++i) {
            int sum = cost[i], max = cost[i];
            while(i<len-1 && str[i] == str[i+1]) {
                sum += cost[i+1];
                if(cost[i+1] > max) max = cost[i+1];
                i++;
            }
            res += sum - max;
        }
        return res;
    }
}