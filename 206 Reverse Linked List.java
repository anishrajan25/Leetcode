/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p=null,c=head,n;
        while(c!=null)
        {
            n=c.next;
            c.next=p;
            p=c;
            c=n;
        }
        return p;
    }
}