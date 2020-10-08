// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/


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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result=new ArrayList<>();
        traverseTree(result,root1);
        traverseTree(result,root2);
        Collections.sort(result);
        return result;
    }
    private void traverseTree(List<Integer> result, TreeNode root) {
        if(root==null) return;
        result.add(root.val);
        traverseTree(result,root.left);
        traverseTree(result,root.right);
    }
}