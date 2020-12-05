// https://leetcode.com/problems/relative-sort-array/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> hm = new HashMap();
        for(int i: arr1) hm.put(i, hm.getOrDefault(i, 0) + 1);
        int l = 0;
        for(int n: arr2) {
            int c = hm.get(n);
            hm.remove(n);
            while(c-- > 0) arr1[l++] = n;
        }
        int k = l;
        for(int n: hm.keySet()) {
            int c = hm.get(n);
            while(c-- > 0) arr1[l++] = n;
        }
        Arrays.parallelSort(arr1, k, arr1.length);
        return arr1;
    }
}