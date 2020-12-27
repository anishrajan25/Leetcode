// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> a = new Stack(), b = new Stack();
        
        ListNode tmp = headA;
        while(tmp != null) {
            a.push(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while(tmp != null) {
            b.push(tmp);
            tmp = tmp.next;
        }
        
        while(!a.isEmpty() && !b.isEmpty()) {
            if(a.peek() == b.peek()) {
                tmp = a.pop();
                b.pop();
            }
            else break;
        }
        
        return tmp;
    }
}


// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode pa = headA, pb = headB;
//         while (pa != pb) {
//             pa = (pa != null) ? pa.next : headB;
//             pb = (pb != null) ? pb.next : headA;
//         }
//         return pa;
//     }
// }