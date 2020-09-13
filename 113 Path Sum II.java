// https://leetcode.com/problems/path-sum-ii/


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
    List<List<Integer>> arr = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<List<Integer>>();
        helper(root, sum, new LinkedList<Integer>());
        return arr;
    }
    
    private void helper(TreeNode root, int sum, LinkedList<Integer> part) {
        if(root == null) return;
        part.add(root.val);
        int now = sum - root.val;
        if(root.left == null && root.right == null && now == 0) {
            arr.add(new ArrayList(part));
            part.removeLast();
            return;
        }
        else {
            helper(root.left, now, part);
            helper(root.right, now, part);
        }
        part.removeLast();
    }
}