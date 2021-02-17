// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        
        ListNode f = head, s = head, p = null;
        while(s != null && s.next != null) {
            p = f;
            f = f.next;
            s = s.next.next;
        }
        if(p != null) {
            p.next = null;
        }
        TreeNode root = new TreeNode(f.val);
        if(f == head) return root;
        root.right = sortedListToBST(f.next);
        root.left = sortedListToBST(head);
        return root;
    }
}