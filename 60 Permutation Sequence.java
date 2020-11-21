// https://leetcode.com/problems/permutation-sequence/

class Solution {
    boolean[] nums;
    
    public String getPermutation(int n, int k) {
        nums = new boolean[10];
        int p = 1;
        for(int i = 1; i <= n; p *= i++);
        return eval(n, new StringBuilder(), k, p / n).toString();
    }
    
    private StringBuilder eval(int n, StringBuilder sb, int k, int p) {
        if(n == 0) return sb;
        
        for(int x = 1; x < 10; ++x) {
            if(nums[x]) continue;
            if(p >= k || k == 1) {
                nums[x] = true;
                return eval(n - 1, sb.append(x), k, p / (n == 1 ? 1 : n - 1));
            }
            k -= p;
        }
        return sb;
    }
}