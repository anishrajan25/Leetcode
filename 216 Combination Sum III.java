//https://leetcode.com/problems/combination-sum-iii/

class Solution {
    private void calcUsingBacktracking(int n, int k, int start, List<List<Integer>> ans, LinkedList<Integer> comb){
        if(n == 0 && comb.size() == k) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        
        if(n < 0 || comb.size() == k) return;
        
        for(int i = start; i <= 9; ++i) {
            comb.add(i);
            calcUsingBacktracking(n - i, k, i + 1, ans, comb);
            comb.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n==0 || k==0) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        
        this.calcUsingBacktracking(n, k, 1, ans, comb);
        
        return ans;
    }
}