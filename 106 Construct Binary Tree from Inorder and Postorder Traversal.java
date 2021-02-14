// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = postorder.length - 1;
        return helper(postorder, inorder, 0, inorder.length);
    }
    
    private TreeNode helper(int[] post, int[] in, int l, int h) {
        if(pi < 0) return null;
        if(l >= h) return null;
        
        TreeNode root = new TreeNode(post[pi--]);
        int i = l;
        while(i < h && in[i] != root.val) i++;
        root.right = helper(post, in, i + 1, h);
        root.left = helper(post, in, l, i);
        
        return root;
    }
}