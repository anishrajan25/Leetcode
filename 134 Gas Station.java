// https://leetcode.com/problems/gas-station/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ind = 0, tank = 0, required = 0;
        for(int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                required += tank;
                ind = i + 1;
                tank = 0;
            }
        }
        return tank >= Math.abs(required) ? ind : -1;
    }
}