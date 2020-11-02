#  https://leetcode.com/problems/excel-sheet-column-number/

class Solution:
    def titleToNumber(self, s: str) -> int:
        d = dict()
        for i, c in enumerate(string.ascii_uppercase):
            d[c] = i
        
        m = 1
        res = 0
        for ind in range(len(s) - 1, -1, -1):
            res += m + m * d[s[ind]]
            m *= 26
        
        return res