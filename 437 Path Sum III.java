// https://leetcode.com/problems/path-sum-iii/

class Solution {
    
    
    int res = 0;
    Map<Integer,Integer> map = new HashMap();
    int k = 0;
    int currSum = 0;
    
    public int pathSum(TreeNode root, int k) {
        this.k = k;
        map.put(0,1);
        pathSum(root);
        return res;    
    }
    
    private void pathSum(TreeNode root){
        if(root == null) return;
        currSum += root.val;
        if(map.containsKey(currSum - k)) res += map.get(currSum - k);
        if(!map.containsKey(currSum)) map.put(currSum ,0);
        map.put(currSum ,map.get(currSum) + 1);
        pathSum(root.left);
        pathSum(root.right);
        map.put(currSum,map.get(currSum) - 1);
        currSum -= root.val;
        
    }
    
}