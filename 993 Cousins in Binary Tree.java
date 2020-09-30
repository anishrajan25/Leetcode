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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0)
        {
            int c=q.size(),r=2;
            while(c!=0)
            {
                TreeNode t=q.poll();
                if(t.left!=null && t.right!=null && ((t.right.val==x || t.right.val==y) && (t.left.val==y || t.left.val==x))) return false;
                if(t.left!=null){
                    if(t.left.val==x || t.left.val==y) r--;
                    q.add(t.left);
                }
                if(t.right!=null){
                    if(t.right.val==x || t.right.val==y) r--;
                    q.add(t.right);
                }
                c--;
            }
            if(r==0)
                return true;
        }
        return false;
    }
}