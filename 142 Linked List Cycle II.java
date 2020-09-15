// https://leetcode.com/problems/linked-list-cycle-ii/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode f = head, s = head;
        while(f!=null && s!=null && f.next!=null) {
            f = f.next.next;
            s = s.next;
            if(f == s) break;
        }
        if(f != s) return null;
        f = head;
        while(f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }
}