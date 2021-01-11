// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res, int h) {
        if(root == null) return;
        
        if(res.size() == h) res.add(root.val);
        else res.set(h, Math.max(res.get(h), root.val));
        
        helper(root.left, res, h + 1);
        helper(root.right, res, h + 1);
    }
}