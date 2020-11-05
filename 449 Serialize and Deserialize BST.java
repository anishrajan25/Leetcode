// https://leetcode.com/problems/serialize-and-deserialize-bst/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize (TreeNode root) {
        if (root == null)
            return "";
        StringBuilder res = new StringBuilder();
        preorder(root, res);
        return res.toString();
    }
    
    private void preorder(TreeNode r, StringBuilder sb) {
        if(r == null) {
            sb.append(",");
            return;
        }
        sb.append(r.val);
        sb.append(",");
        preorder(r.left, sb);
        preorder(r.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize (String data) {
        String S [] = data.split (",");
        Queue <String> queue = new LinkedList ();
        for (String s: S)
            queue.add (s);
        return deserializeUtil (queue);
    }
    
    public TreeNode deserializeUtil (Queue <String> queue) {
        if(queue.isEmpty()) return null;
        String s = queue.poll ();
        if (s.equals (""))
            return null;
        TreeNode node = new TreeNode (Integer.valueOf (s));
        node.left = deserializeUtil (queue);
        node.right = deserializeUtil (queue);
        return node;
    }
}