// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    int pi;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pi = 0;
        return helper(preorder, inorder, 0, inorder.length);
    }
    
    private TreeNode helper(int[] pre, int[] in, int l, int h) {
        if(pi >= pre.length) return null;
        if(l >= h) return null;
        
        TreeNode root = new TreeNode(pre[pi++]);
        int i = l;
        while(i < h && in[i] != root.val) i++;
        root.left = helper(pre, in, l, i);
        root.right = helper(pre, in, i + 1, h);
        
        return root;
    }
}