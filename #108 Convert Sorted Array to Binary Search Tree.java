/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }
    private TreeNode sortedArrayToBST(int[] a, int l,int r)
    {
        if(l>=r) return null;
        int m=l+(r-l)/2;
        TreeNode t=new TreeNode(a[m]);
        t.left=sortedArrayToBST(a, l, m);
        t.right=sortedArrayToBST(a, m+1, r);
        return t;
    }
}