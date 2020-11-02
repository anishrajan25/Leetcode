// https://leetcode.com/problems/most-frequent-subtree-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, Integer> hm = new HashMap();
    int max = Integer.MIN_VALUE;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList();
        compute(root);
        for(Map.Entry<Integer, Integer> e: hm.entrySet())
            if(e.getValue() == max)
                arr.add(e.getKey());
        
        int[] res = new int[arr.size()];
        int k = 0;
        
        for(int v: arr) res[k++] = v;
        
        return res;
    }
    
    private int compute(TreeNode r) {
        if(r == null) return 0;
        
        int sum = compute(r.left) + compute(r.right) + r.val; 
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        max = Math.max(max, hm.get(sum));
        
        return sum;
    }
}