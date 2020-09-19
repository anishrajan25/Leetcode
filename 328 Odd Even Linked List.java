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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode d=new ListNode(0),m=head,t=d,p=null;
        while(m!=null && m.next!=null) {
            t.next=m.next;
            m.next=m.next.next;
            t=t.next;
            p=m;
            m=m.next;
        }
        if(m!=null) m.next=d.next;
        else p.next=d.next;
        t.next=null;
        return head;
    }
}