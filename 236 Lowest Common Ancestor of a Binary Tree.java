// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans;
    
    public Solution() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return this.ans;
    }
    
    private int helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return 0;
        
        int l = helper(root.left, p, q);
        
        int r = helper(root.right, p, q);
        
        int c = (root == p || root == q) ? 1 : 0;
        
        if(l + r + c >= 2) this.ans = root;
        
        return l + r + c > 0 ? 1 : 0;
    }
}