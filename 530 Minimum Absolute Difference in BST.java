// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans, prev;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        prev = -2000;
        helper(root);
        return ans;
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        
        helper(root.left);
        ans = Math.min(ans, root.val - prev);
        prev = root.val;
        helper(root.right);
    }
}