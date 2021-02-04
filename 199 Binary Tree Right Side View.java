// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll = new ArrayList<Integer>();
        helper(root, ll, 0);
        return ll;
    }
    
    private void helper(TreeNode root, List<Integer> ll, int depth) {
        if(root == null) return;
        
        if(ll.size() == depth) ll.add(root.val);
        helper(root.right, ll, depth + 1);
        helper(root.left, ll, depth + 1);
    }
}
