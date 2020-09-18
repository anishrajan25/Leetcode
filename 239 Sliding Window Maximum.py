# https://leetcode.com/problems/sliding-window-maximum/

class Solution:
    
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if k == 1: return nums
        ans = []
        m = max(nums[0:k])
        ans.append(m)
        i, j = 1, k
        
        while(j < len(nums)):
            if nums[j] >= m: m = nums[j]
            elif nums[i-1] == m: m = max(nums[i: j+1])
            ans.append(m)
            i += 1
            j += 1
        
        return ans
            