/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d=new ListNode(0),t=d;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                t.next=l1;
                l1=l1.next;
            }
            else
            {
                t.next=l2;
                l2=l2.next;
            }
            t=t.next;
        }
        if(l1!=null)
            t.next=l1;
        else
            t.next=l2;
        return d.next;
    }
}