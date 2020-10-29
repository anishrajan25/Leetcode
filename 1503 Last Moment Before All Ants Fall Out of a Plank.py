#  https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/

class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        if len(left) == 0: return n - min(right)
        if len(right) == 0: return max(left)
        return max(n-min(right), max(left))