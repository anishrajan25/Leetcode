/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d=new ListNode(0),f=d,s=d;
        d.next=head;
        while(n>=0)
        {
            s=s.next;
            n--;
        }
        while(s!=null)
        {
            f=f.next;
            s=s.next;
        }
        f.next=f.next.next;
        return d.next;
    }
}