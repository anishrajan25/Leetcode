// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/submissions/public class Solution 


{
    public ListNode removeZeroSumSublists(ListNode head) 
    {
        ListNode Head=new ListNode(0);
        Head.next=head;
        ListNode cur=Head;
        while(cur!=null)
        {
            int sum=0;
            while(head!=null)
            {
                sum+=head.val;
                if(sum==0)
                {
                   cur.next=head.next; 
                }
                head=head.next;
            }
            cur=cur.next;
            if(cur!=null)
            {
                head=cur.next;
            }
        }
        return Head.next; 
    }
}