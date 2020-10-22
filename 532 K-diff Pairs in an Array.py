#  https://leetcode.com/problems/k-diff-pairs-in-an-array/



class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        d = {}
        res = 0
        for i in nums:
            if i not in d: d[i] = 1
            else: d[i] += 1
        
        for i in d:
            if i - k in d:
                if k != 0: res += 1
                elif d[i] > 1: res += 1
                d[i - k] -= 1
        
        return res
