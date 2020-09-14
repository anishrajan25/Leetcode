// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        return helper(root, null);
    }
    
    private Node helper(Node root, Node next) {
        if(root == null) return null;
        root.next = next;
        Node lr = null, rr = null;
        if(root.right != null) {
            Node tmp = root.next;
            while(rr == null && tmp != null) {
                if(tmp.right != null) rr = tmp.right;
                if(tmp.left != null) rr = tmp.left;
                tmp = tmp.next;
            }
            helper(root.right, rr);
        }
        if(root.left != null) {
            if(root.right == null) {
                Node tmp = root.next;
                while(lr == null && tmp != null) {
                    if(tmp.right != null) lr = tmp.right;
                    if(tmp.left != null) lr = tmp.left;
                    tmp = tmp.next;
                }
            }
            else lr = root.right;
            helper(root.left, lr);
        }
        
        return root;
    }
}