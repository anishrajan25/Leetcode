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
    int sum;
    public int maxPathSum(TreeNode root) {
        sum=Integer.MIN_VALUE;
        helper(root);
        return sum;
    }
    private int helper(TreeNode t) {
        if(t==null) return 0;
        int l=Math.max(helper(t.left),0),r=Math.max(0,helper(t.right));
        sum=Math.max(sum,t.val+l+r);
        return t.val+Math.max(l,r);
    }
}