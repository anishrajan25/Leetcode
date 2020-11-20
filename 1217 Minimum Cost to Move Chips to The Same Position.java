// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

class Solution {
    public int minCostToMoveChips(int[] position) {
        if(position[0] == position[position.length - 1]) return 0; 
        int ans = 0;
        for(int i = position.length - 1; i > 0 && position[i] != position[0]; --i) {
            int j = i;
            while(position[i] == position[i - 1]) --i;
            ans += ((position[j] - position[0]) & 1) * (j - i + 1);
        }
        
        return ans;
    }
}