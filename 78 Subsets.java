// https://leetcode.com/problems/subsets/

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        backtracking(nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    private void backtracking(int[] n, int s, List<Integer> ls) {
        res.add(new ArrayList(ls));
        
        for(int i = s; i < n.length; ++i) {
            ls.add(n[i]);
            backtracking(n, i+1, ls);
            ls.remove(ls.size() - 1);
        }
    }
}