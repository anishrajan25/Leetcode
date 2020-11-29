// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

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
    long ans, total;
    public int maxProduct(TreeNode root) {
        total = helper(root);
        helper(root);
        return (int)(ans % 1000000007);
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int sum = root.val + helper(root.left) + helper(root.right);
        ans = Math.max(ans, sum * (total - sum));
        return sum;
    }
}