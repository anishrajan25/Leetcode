// https://leetcode.com/problems/permutations-ii/

class Solution {
    boolean[] added;
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.parallelSort(nums);
        added = new boolean[nums.length];
        res = new ArrayList<List<Integer>>();
        permute(nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    private void permute(int[] nums, int s, List<Integer> l) {
        if(s == nums.length) {
            res.add(new ArrayList<Integer>(l));
            return;
        }
        
        for(int i = 0; i < nums.length; ++i) {
            if(added[i]) continue;
            added[i] = true;
            l.add(nums[i]);
            permute(nums, s + 1, l);
            l.remove(l.size() - 1);
            added[i] = false;
            while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}