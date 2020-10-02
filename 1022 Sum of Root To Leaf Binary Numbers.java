// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/


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
    
    public void preorder(TreeNode r, int num) {
        if (r != null) {
            num = (num << 1) | r.val;
            if (r.left == null && r.right == null) {
            sum += num;
            }
            preorder(r.left, num);
            preorder(r.right, num);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return sum;
    }
}