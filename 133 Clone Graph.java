// https://leetcode.com/problems/clone-graph/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> v = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node n = new Node(node.val);
        v.put(node, n);
        n.neighbors = new ArrayList();
        for(Node x: node.neighbors) {
            if(v.containsKey(x)) n.neighbors.add(v.get(x));
            else n.neighbors.add(cloneGraph(x));
        }
        return n;
    }
}