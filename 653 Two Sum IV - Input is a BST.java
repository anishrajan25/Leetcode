// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
    int i = 0;
    TreeNode root;
    public boolean findTarget(TreeNode root, int k) {
        if(i == 0) {this.root = root; ++i;} 
        if(root == null) return false;
        if(find(this.root, root, k - root.val)) return true;
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
    
    private boolean find(TreeNode r, TreeNode t, int k) {
        if(r == null) return false;
        if(r != t && r.val == k) return true;
        if(r.val > k) return find(r.left, t, k);
        return find(r.right, t, k);
    }
}