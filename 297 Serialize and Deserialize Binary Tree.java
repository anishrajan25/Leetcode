// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/


public class Codec {
    // Encodes a tree to a single string
    private StringBuilder storage;
    private void preOrder(TreeNode root){
        if(root == null){
            storage.append("").append(",");
            return;
        }
        storage.append(root.val).append(",");
        preOrder(root.left);
        preOrder(root.right);
    }
    public String serialize(TreeNode root) {
        storage = new StringBuilder();
        preOrder(root);
        return storage.toString();
    }
    
    private TreeNode deserialize(Queue<String>values){
        if(values.isEmpty()) return null;
        String current = values.remove();
        if(current.equals("")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(current));
        node.left = deserialize(values);
        node.right = deserialize(values);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String>fringe = new LinkedList<>();
        String []stored = data.split(",");
        for(String value : stored){
            fringe.add(value);
        }
        return deserialize(fringe);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));