// https://leetcode.com/problems/merge-in-between-linked-lists/

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tmp = list1;
        b -= a;
        while(a-- > 1) tmp = tmp.next;
        ListNode n = tmp.next;
        tmp.next = list2;
        while(tmp.next != null) tmp = tmp.next;
        while(b-- > 0) n = n.next;
        tmp.next = n.next;
        return list1;
    }
}