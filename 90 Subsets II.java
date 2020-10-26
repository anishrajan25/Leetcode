// https://leetcode.com/problems/subsets-ii/

class Solution {
    List<List<Integer>> res;
    HashSet<List<Integer>> added;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<List<Integer>>();
        added = new HashSet();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    private void backtracking(int[] n, int s, List<Integer> ls) {
        if(!added.contains(ls)) {
            res.add(new ArrayList(ls));
            added.add(ls);
        }
        
        for(int i = s; i < n.length; ++i) {
            ls.add(n[i]);
            backtracking(n, i+1, ls);
            ls.remove(ls.size() - 1);
        }
    }
}