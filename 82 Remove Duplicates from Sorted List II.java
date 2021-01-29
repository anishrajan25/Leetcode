// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode d = new ListNode(0), td = d;
        while(head != null) {
            ListNode tmp = head;
            while(tmp.next != null && tmp.val == tmp.next.val) tmp = tmp.next;
            if(tmp == head) {
                td.next = tmp;
                td = td.next;
            }
            head = tmp.next;
        }
        td.next = null;
        return d.next;
    }
}