// https://leetcode.com/problems/find-lucky-integer-in-an-array/

class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap();
        
        for(int n: arr) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        
        int ans = -1;
        for(int n: hm.keySet()) {
            if(hm.get(n) == n) ans = Math.max(ans, n);
        }
        
        return ans;
    }
}