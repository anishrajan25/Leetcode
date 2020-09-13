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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans= new LinkedList<List<Integer>>();
        int c;
        while(!q.isEmpty())
        {
            c=q.size();
            List<Integer> tmp=new LinkedList<>();
            while (c>0)
            {
                TreeNode t1 = q.poll();
                tmp.add(t1.val);
                if(t1.left!=null) q.add(t1.left);
                if(t1.right!=null) q.add(t1.right);
                c--;
            }
            ans.add(tmp);
        }
        return ans;
    }
}