// https://leetcode.com/problems/reverse-linked-list-ii/


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
class Solution {
    
    private ListNode rev(ListNode head, ListNode end) {
        ListNode curr = head, prev = end, next = head.next;
        while(curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        if(m == n) return head;
        ListNode start = null, end = null, tmp = head;
        while(tmp != null) {
            if(--m == 1) start = tmp;
            if(n-- == 0) end = tmp;
            tmp = tmp.next;
        }
        if(start == null) head = rev(head, end);
        else start.next = rev(start.next, end);
        return head;
    }
}