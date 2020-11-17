// https://leetcode.com/problems/insertion-sort-list/

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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head), tmp = head;
        while(tmp.next != null) {
            if(tmp.val > tmp.next.val) {
                ListNode tmp2 = tmp.next;
                tmp.next = tmp.next.next;
                ListNode tmp3 = dummy;
                while(tmp3.next != tmp && tmp3.next.val < tmp2.val) tmp3 = tmp3.next;
                tmp2.next = tmp3.next;
                tmp3.next = tmp2;
            }
            else tmp = tmp.next;
        }
        
        return dummy.next;
    }
}