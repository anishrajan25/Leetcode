// https://leetcode.com/problems/convert-bst-to-greater-tree/

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
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        getSum(root);
        convert(root);
        return root;
    }
    
    private void getSum(TreeNode root) {
        if(root == null) return;
        
        sum += root.val;
        getSum(root.left);
        getSum(root.right);
    }
    
    private void convert(TreeNode root) {
        if(root == null) return;
        
        convert(root.left);
        sum -= root.val;
        root.val += sum;
        convert(root.right);
    }
}
