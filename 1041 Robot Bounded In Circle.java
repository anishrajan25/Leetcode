// https://leetcode.com/problems/robot-bounded-in-circle/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] op = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //                          N       E       S         W
        int x = 0, y = 0;
        int opi = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L')
                opi = (opi + 3) % 4;
            else if (c == 'R')
                opi = (opi + 1) % 4;
            else {
                x += op[opi][0];
                y += op[opi][1];   
            }    
        }
        return (x == 0 && y == 0) || (opi != 0);
    }
}

//          ANOTHER SOLUTION

// class Solution {
//     public boolean isRobotBounded(String instructions) {
//         int[] op = {-1, 1, 1, -1}, pos = {0, 0};
//         int opi = 1, posi = 1;
//         for(char x: instructions.toCharArray()) {
//             if( x == 'G')
//                 pos[posi] += op[opi];
//             else if( x == 'L') {
//                 posi = (posi + 1) % 2;
//                 opi = (4 + opi - 1) % 4;
//             }
//             else {
//                 posi = (posi + 1) % 2;
//                 opi = (4 + opi + 1) % 4;
//             }
//         }
//         if((pos[0] == 0 && pos[1] == 0) || opi != 1) return true;
//         return false;
//     }
// }