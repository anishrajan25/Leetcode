/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return divide(lists,0,lists.length-1);
    }
    private ListNode divide(ListNode[] arr,int b,int e)
    {
        if(b>=e)
            return arr[e];
        int mid=(b+e)/2;
        ListNode l=divide(arr,b,mid),r=divide(arr,mid+1,e);
        return merge(l,r);
    }
    private ListNode merge(ListNode l,ListNode r)
    {
        ListNode x=new ListNode(0),t=x;
        while(l!=null && r!=null)
        {
            if(l.val<r.val)
            {
                t.next=l;
                l=l.next;
            }
            else
            {
                t.next=r;
                r=r.next;
            }
            t=t.next;
        }
        if(l==null)
            t.next=r;
        if(r==null)
            t.next=l;
        return x.next;
    }
}