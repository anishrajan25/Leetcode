// https://leetcode.com/problems/binary-search-tree-iterator/

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
class BSTIterator {
    LinkedList<Integer> arr;
    public BSTIterator(TreeNode root) {
        arr = new LinkedList<Integer>();
        inorder(root);
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        arr.addLast(root.val);
        inorder(root.right);
    }
    
    public int next() {
        return arr.pollFirst();
    }
    
    public boolean hasNext() {
        return !arr.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */