// https://leetcode.com/problems/unique-number-of-occurrences/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int n: arr) hm.put(n, hm.getOrDefault(n, 0) + 1);
        return hm.values().size() == new HashSet(hm.values()).size();
    }
}