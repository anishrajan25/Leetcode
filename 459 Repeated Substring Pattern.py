# https://leetcode.com/problems/repeated-substring-pattern/

class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        if len(s) < 2: return False
        for i in range(1, len(s) // 2 + 1):
            if len(s) % i != 0: continue
            t = s[:i]
            m = len(s) // i
            if  t * m == s: return True
        return False