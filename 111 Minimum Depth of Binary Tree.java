// https://leetcode.com/problems/minimum-depth-of-binary-tree/

class Solution {
    Integer minimumDepthValue = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
       if(root == null) {
           return 0;
       }
     getMinDepth(root, 0);
        return minimumDepthValue;
    }
    
    private void getMinDepth(TreeNode root, Integer depth) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            minimumDepthValue = Math.min(minimumDepthValue, depth + 1);
        }
        getMinDepth(root.left, depth + 1);
        getMinDepth(root.right, depth + 1);
    }
}