// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node tmp = head;
        while(tmp != null) {
            if(tmp.child != null) {
                Node r = flatten(tmp.child);
                Node t = tmp.next;
                while(r.next != null) {
                    r = r.next;
                }
                if(t != null) {
                    r.next = t;
                    t.prev = r;
                }
                tmp.next = tmp.child;
                tmp.child.prev = tmp;
                tmp.child = null;
                tmp = r.next;
            }
            else tmp = tmp.next;
        }
        
        return head;
    }
}