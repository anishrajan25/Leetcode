// https://leetcode.com/problems/rotate-list/

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 0;
        
        ListNode tmp = head;
        while(tmp != null) {
            ++len;
            tmp = tmp.next;
        }
        
        k %= len;
        if(k == 0) return head;
        int stop = len - k;
        tmp = head;
        while(tmp != null && stop != 1) {
            tmp = tmp.next;
            stop--;
        }
        
        ListNode newHead = tmp.next;
        tmp.next = null;
        tmp = newHead;
        
        while(tmp.next!=null) tmp = tmp.next;
        
        tmp.next = head;
        
        return newHead;
    }
}