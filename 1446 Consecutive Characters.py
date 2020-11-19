#  https://leetcode.com/problems/consecutive-characters/

class Solution:
    def maxPower(self, s: str) -> int:
        if len(s) <= 1: return len(s)
        res, l = 0, 0
        for i in range(len(s) - 1):
            if s[i + 1] != s[i]:
                res = max(res, i - l + 1)
                l = i + 1
        return max(res, i - l + 2)