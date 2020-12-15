// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        l.add(root);
        boolean leftToRight = true;
        while(!l.isEmpty()) {
            List<Integer> tmp = new ArrayList();
            LinkedList<TreeNode> next = new LinkedList<TreeNode>();
            
            while(!l.isEmpty()) {
                TreeNode t = l.removeFirst();
                tmp.add(t.val);
                if(leftToRight) {
                    if(t.left != null) next.addFirst(t.left);
                    if(t.right != null) next.addFirst(t.right);
                }
                else {
                    if(t.right != null) next.addFirst(t.right);
                    if(t.left != null) next.addFirst(t.left);
                }
            }
            leftToRight = !leftToRight;
            res.add(tmp);
            l = next;
        }
        
        return res;
    }
}


// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         if(root == null) return new LinkedList<List<Integer>>();
//         LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
//         LinkedList<TreeNode> itr = new LinkedList();
//         LinkedList<Integer> store = new LinkedList<Integer>();
//         boolean right = true;
        
//         itr.add(null);
//         itr.addFirst(root);
//         while(itr.size() > 1) {
//             TreeNode tmp = null;
            
//             if(right) {
//                 tmp = itr.pollFirst();
//                 if(tmp.left != null) itr.addLast(tmp.left);
//                 if(tmp.right != null) itr.addLast(tmp.right);
//             }
//             else {
//                 tmp = itr.pollLast();
//                 if(tmp.right != null) itr.addFirst(tmp.right);
//                 if(tmp.left != null) itr.addFirst(tmp.left);
//             }
            
//             store.add(tmp.val);
            
//             if((right && itr.peekFirst() == null) || (!right && itr.peekLast() == null)) {
//                 res.addLast(store);
//                 store = new LinkedList();
//                 right = !right;
//             }
//         }
//         return res;
//     }
// }