// https://leetcode.com/problems/split-linked-list-in-parts/

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
    int size, rem, k, s;
    ListNode[] res;
    public ListNode[] splitListToParts(ListNode root, int k) {
        this.k = k;
        s = 0; size = 0; rem = 0;
        res = new ListNode[k];
        helper(root);
        return res;
    }
    
    public void helper(ListNode root) {
        if(root == null) {
            if(size < k) {
                k = size;
                size = 1;
                rem = 0;
            }
            else {
                rem = size % k;
                size /= k;
            }
            s = size + (rem >= k ? 1 : 0);
            return;
        }
        
        size++;
        helper(root.next);
        s--;
        if(s == size + (rem >= k ? 0 : -1)) {
            root.next = null;
            
        }
        if(s == 0 && k > 0) {
            res[--k] = root;
            s = size;
            if(rem >= k) {
                s++;
            }
        }
    }
}