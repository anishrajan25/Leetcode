/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null) return true;
        int len = 0;
        ListNode node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        int mid =len / 2 + len % 2;
        ListNode prev = null;
        ListNode curr = head;
        while(mid > 0){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            mid--;
        }
        if(len % 2 == 1)
        {
            prev=prev.next;
        } 
        return compare(prev, curr);
    }
    
    private boolean compare(ListNode node1, ListNode node2){
        while(node1 != null){
            if(node1.val != node2.val) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}