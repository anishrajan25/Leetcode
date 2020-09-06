/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode tempNext=head.next.next,tempFirst=head.next,tempSecond=head;
        head=tempFirst;
        head.next=tempSecond;
        head.next.next=swapPairs(tempNext);
        return head;
    }
}