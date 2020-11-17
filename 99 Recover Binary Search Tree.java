// https://leetcode.com/problems/recover-binary-search-tree/

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
    TreeNode f, s, prev;
    public void recoverTree(TreeNode root) {
        f = s = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        traverse(root);
        
        int t = f.val;
        f.val = s.val;
        s.val = t;
    }
    
    private void traverse(TreeNode r) {
        if(r == null) return;
        
        traverse(r.left);
        
        if(f == null && prev.val > r.val) f = prev;
        
        if(f != null && prev.val > r.val) s = r;
        
        prev = r;
        
        traverse(r.right);
    }
}