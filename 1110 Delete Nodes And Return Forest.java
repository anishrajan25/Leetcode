//  https://leetcode.com/problems/delete-nodes-and-return-forest/submissions/

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
    HashMap<Integer, Boolean> del;
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        del = new HashMap<Integer, Boolean>();
        ans = new ArrayList<>();
        for(int i = 0; i < to_delete.length; i++)
            del.put(to_delete[i], true);
        if(!del.containsKey(root.val))  ans.add(root);
        trav(root, null);
        
        return ans;
    }
    
    public void trav(TreeNode root, TreeNode parent){
        if(root == null)    return ;
        trav(root.left, root);
        trav(root.right, root);
        
        if(del.containsKey(root.val))   {
            if(parent!=null && parent.left == root) parent.left = null;
            if(parent!=null && parent.right == root)parent.right = null;
            if(root.left != null)   ans.add(root.left);
            if(root.right != null)   ans.add(root.right);
        }
    }
    
}


// ANOTHER SOLUTION
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int d : to_delete) {
            set.add(d);
        }
        delete(result, set, root, false);
        return result;
    }
    
    public void delete(List<TreeNode> result, Set<Integer> set, TreeNode curr, boolean added) {
        if (curr == null) return;
        if (!set.contains(curr.val) && !added) {
            result.add(curr);
            added = true;
        }

        if (curr.left != null && set.contains(curr.left.val)) {
            delete(result, set, curr.left, false);
            curr.left = null;
        } else {
            delete(result, set, curr.left, added);
        }
        
        if (curr.right != null && set.contains(curr.right.val)) {
            delete(result, set, curr.right, false);
            curr.right = null;
        } else {
            delete(result, set, curr.right, added);
        }
    }
}