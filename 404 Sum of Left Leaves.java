// https://leetcode.com/problems/sum-of-left-leaves/


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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        helper(root, false);
        return sum;
    }
    
    private void helper(TreeNode r, boolean left) {
        if(left && r.left == null && r.right == null) sum += r.val;
        
        if(r.left != null) helper(r.left, true);
        if(r.right != null) helper(r.right, false);
    }
}