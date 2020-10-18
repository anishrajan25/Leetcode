// https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList(), ans);
        
        return ans;
    }
    
    private void backtrack(int[] c, int t, int s, ArrayList<Integer> comb, List<List<Integer>> ans) {
        if(t == 0) {
            ans.add(new ArrayList(comb));
            return;
        }
        
        for(int i = s; i < c.length; i++) {
            if(i > s && c[i] == c[i-1]) continue;
            if(c[i] > t) break;
            comb.add(c[i]);
            backtrack(c, t - c[i], i + 1, comb, ans);
            comb.remove(comb.size() - 1);
        }
    }
}