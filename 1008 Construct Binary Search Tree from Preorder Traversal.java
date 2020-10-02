class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertIntoBSThelper(root, preorder[i]);
        }
        return root;
    }
    
    public static void insertIntoBSThelper(TreeNode root, int val) {
    if (root.val < val) {
      if (root.right == null) {
        TreeNode right = new TreeNode(val);
        root.right = right;
        return;
      } else {
        insertIntoBSThelper(root.right, val);
      }
    } else {
      if (root.left == null) {
        TreeNode left = new TreeNode(val);
        root.left = left;
        return;
      } else {
        insertIntoBSThelper(root.left, val);
      }
    }
  }
}