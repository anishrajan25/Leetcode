// https://leetcode.com/problems/maximum-binary-tree/


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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return new TreeNode();
        if(nums.length == 1) return new TreeNode(nums[0]);
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int s, int e) {
        if(s > e) return null;
        int mi = s;
        for(int i = s; i <= e; ++i) mi = nums[mi] < nums[i] ? i : mi;
        TreeNode n = new TreeNode(nums[mi]);
        n.left = helper(nums, s, mi - 1);
        n.right = helper(nums, mi + 1, e);
        
        return n;
    }
}