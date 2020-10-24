# https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/


class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        res, sum = 101, 0
        for i in nums:
            sum += i
            res = min(sum, res)
        
        return abs(res) + 1 if res < 0 else 1