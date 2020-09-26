// https://leetcode.com/problems/add-one-row-to-tree/


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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return null;
        if(d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        System.out.println(root.val + " " + d);
        if(d == 2) {
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
            return root;
        }
        d--;
        if(root.left != null) root.left = addOneRow(root.left, v, d);
        if(root.right != null) root.right = addOneRow(root.right, v, d);
        return root;
    }
    
    // private TreeNode helper()
}