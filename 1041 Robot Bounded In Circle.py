// https://leetcode.com/problems/robot-bounded-in-circle/

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        go = {'N':(0,1), 'S':(0,-1), 'W':(-1,0), 'E':(1,0)}
        left = {'N':'W', 'W':'S', 'S':'E', 'E':'N'}
        right = {'N':'E', 'E':'S', 'S':'W', 'W':'N'}
        current = [0, 0]
        direction = 'N'
        
        for i in instructions:
            if i == 'G':
                x, y = go[direction]
                current[0] += x
                current[1] += y
            elif i == 'L':
                direction = left[direction]
            else:
                direction = right[direction]
        
        if current == [0,0] or direction != 'N':
            return True
        else:
            return False
        
     ##     ANOTHER SOLUTION
        
        """
        op = [-1, 1, 1, -1]
        opi = 1
        pos = [0, 0]
        posi = 1
        for x in instructions:
            if x == 'G':
                pos[posi] = pos[posi] + op[opi]
            elif x == 'L':
                posi = (posi + 1) % 2
                opi = (4 + opi - 1) % 4
            else:
                posi = (posi + 1) % 2
                opi = (4 + opi + 1) % 4
        if pos == [0, 0] or opi != 1: return True
        return False"""