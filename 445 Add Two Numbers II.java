// https://leetcode.com/problems/add-two-numbers-ii/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int r;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1), len2 = length(l2);
        r = 0;
        if(len1 > len2) {
            helper(l1, l2, len1 - len2);
            if(r > 0) return new ListNode(r, l1);
            return l1;
        }
        helper(l2, l1, len2 - len1);
        if(r > 0) return new ListNode(r, l2);
        return l2;
    }

    private void helper(ListNode l1, ListNode l2, int d) {
        if(l1 == null && l2 == null) return;
        System.out.println(l1.val + " " + l2.val);
        if(d > 0) {
            helper(l1.next, l2, --d);
            int v = l1.val + r;
            l1.val = v % 10;
            r = v / 10;
        }
        else {
            helper(l1.next, l2.next, 0);
            int v = l1.val + l2.val + r;
            l1.val = v % 10;
            r = v / 10;
        }
    }
    
    private int length(ListNode head) {
        int l = 0;
        while(head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
}