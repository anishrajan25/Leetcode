/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int r=0,s=0;
        ListNode t1=l1,t2=l2,res=new ListNode(0),p=res;
        while(t1!=null && t2!=null)
        {
            s=t1.val+t2.val+r;
            p.next=new ListNode(s%10);
            r=s/10;
            t1=t1.next;t2=t2.next;p=p.next;
        }
        if(t1!=null)
            while(t1!=null)
            {
                s=t1.val+r;
                p.next=new ListNode(s%10);
                r=s/10;
                t1=t1.next;p=p.next;
            }
        else if(t2!=null)
            while(t2!=null)
            {
                s=t2.val+r;
                p.next=new ListNode(s%10);
                r=s/10;
                t2=t2.next;p=p.next;
            }
        if(r>0)
            p.next=new ListNode(r);
        return res.next;
    }
}