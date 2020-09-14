# https://leetcode.com/problems/sum-root-to-leaf-numbers/


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sum = 0
    def sumNumbers(self, root: TreeNode) -> int:
        def helper(root, num):
            if not root: return
            if not root.left and not root.right:
                self.sum += num * 10 + root.val
                return
            num = num * 10 + root.val
            helper(root.left, num)
            helper(root.right, num)
        
        helper(root, 0)
        
        return self.sum