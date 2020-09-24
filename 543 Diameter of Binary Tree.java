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
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
        d=1;
        height(root);
        return d-1;
    }
    public int height(TreeNode root)
    {
        if(root==null) return 0;
        int l=height(root.left),r=height(root.right);
        d=Math.max(d,l+r+1);
        return 1+Math.max(l,r);
    }
}