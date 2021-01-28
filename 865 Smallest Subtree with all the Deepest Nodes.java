// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root, 0).node;
    }
    
    private Info helper(TreeNode root, int h) {
        if(root == null) return new Info(h, null);
        
        Info l = null, r = null;
        if(root.left != null) l = helper(root.left, h + 1);
        if(root.right != null) r = helper(root.right, h + 1);
        
        if(l != null && r != null ) {
            if(l.d == r.d) return new Info(r.d, root);
            if(l.d > r.d) return l;
            if(r.d > l.d) return r;
        }
        
        if(l == null && r == null) return new Info(h, root);
        
        if(l == null) return r;
        if(r == null) return l;
        return null;
    }
    
    static class Info {
        int d;
        TreeNode node;
        
        Info(int x, TreeNode n) {
            node = n;
            d = x;
        }
    }
}