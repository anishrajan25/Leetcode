// https://leetcode.com/problems/find-mode-in-binary-search-tree/

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
    int len = 0;
    ArrayList <Integer> arr;
    Map <Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        
        arr=new ArrayList<Integer>();
        map=new HashMap<Integer,Integer>();
        if(root!=null)
        getLen(root);
        int a[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
            a[i]=arr.get(i);
        return a;
    }
    

    private void getLen(TreeNode node) {
        if (node == null) return ;
            map.put(node.val,map.getOrDefault(node.val,0)+1);
        if(map.get(node.val)>len)
        {
            len=map.get(node.val);
            arr=new ArrayList<Integer>();
            arr.add(node.val);
        }
        else if(len==map.get(node.val) && arr.get(arr.size()-1)!=node.val)
        {
            arr.add(node.val);
        }
         getLen(node.left);
        getLen(node.right);

    }
    
}