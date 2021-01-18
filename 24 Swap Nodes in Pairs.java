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
        if(head == null || head.next == null) return head;
        
        ListNode d = new ListNode(0, head), tmp = d;
        while(tmp != null && tmp.next != null && tmp.next.next != null) {
            ListNode n1 = tmp.next;
            tmp.next = n1.next;
            n1.next = tmp.next.next;
            tmp.next.next = n1;
            tmp = n1;
        }
        
        return d.next;
    }
}


// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if(head==null || head.next==null) return head;
//         ListNode tempNext=head.next.next,tempFirst=head.next,tempSecond=head;
//         head=tempFirst;
//         head.next=tempSecond;
//         head.next.next=swapPairs(tempNext);
//         return head;
//     }
// }