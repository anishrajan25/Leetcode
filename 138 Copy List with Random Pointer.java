// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> hm = new HashMap();
        Node tmp = head;
        while(tmp != null) {
            hm.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp != null) {
            Node n = hm.get(tmp);
            n.next = hm.get(tmp.next);
            n.random = hm.get(tmp.random);
            tmp = tmp.next;
        }
        
        return hm.get(head);
    }
}