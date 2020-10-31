#  https://leetcode.com/problems/alphabet-board-path/


class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        x, y = 0, 0
        path = []
        for c in target:
            loc = (ord(c) - 97)
            i, j = loc // 5, loc % 5
            dx, dy = i - x, j - y
            if x == 5:
                if dx < 0: path.extend(['U'] * abs(dx))
                elif dx > 0: path.extend(['D'] * dx)
                if dy < 0: path.extend(['L'] * abs(dy))
                elif dy > 0: path.extend(['R'] * dy)
            else:
                if dy < 0: path.extend(['L'] * abs(dy))
                elif dy > 0: path.extend(['R'] * dy)
                if dx < 0: path.extend(['U'] * abs(dx))
                elif dx > 0: path.extend(['D'] * dx)
            path += '!'
            x, y = i, j
        
        return "".join(path)

        
# class Solution:
#     def alphabetBoardPath(self, target: str) -> str:
#         x, y = 0, 0
#         path = str()
#         for c in target:
#             loc = (ord(c) - 97)
#             i, j = loc // 5, loc % 5
#             dx, dy = i - x, j - y
#             if x == 5:
#                 if dx < 0: path += 'U' * abs(dx)
#                 elif dx > 0: path += 'D' * dx
#                 if dy < 0: path += 'L' * abs(dy)
#                 elif dy > 0: path += 'R' * dy
#             else:
#                 if dy < 0: path += 'L' * abs(dy)
#                 elif dy > 0: path += 'R' * dy
#                 if dx < 0: path += 'U' * abs(dx)
#                 elif dx > 0: path += 'D' * dx
#             path += '!'
#             x, y = i, j
        
#         return path