// https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList();
        
        backtrack(candidates, target, 0, new ArrayList(), ans);
        
        return ans;
    }
    
    private void backtrack(int[] c, int t, int s, ArrayList<Integer> comb, List<List<Integer>> ans) {
        if(t == 0) {
            ans.add(new ArrayList(comb));
            return;
        }
        
        if(t < 0) return;
        
        for(int i = s; i < c.length; i++) {
            if(c[i] > t) continue;
            comb.add(c[i]);
            backtrack(c, t - c[i], i, comb, ans);
            comb.remove(comb.size() - 1);
        }
    }
}