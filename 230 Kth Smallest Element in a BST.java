// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    int pos = 0, num = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        helper( root,  k);
        return num;
    }
    
    private void helper(TreeNode root, int k) {
        if(root == null) return;
        helper(root.left, k);
        ++pos;
        if(k == pos) num = root.val;
        helper(root.right, k);
    }
}