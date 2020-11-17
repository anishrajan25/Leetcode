// https://leetcode.com/problems/find-latest-group-of-size-m/

class Solution {
    public int findLatestStep(int[] arr, int m) {
        if(arr.length == m) return m;
        TreeSet<Integer> s = new TreeSet();
        
        for(int i = arr.length - 1; i >= 0; --i) {
            s.add(arr[i]);
            
            Integer l = s.lower(arr[i]);
            if(l == null) l = 0;
            
            Integer r = s.higher(arr[i]);
            if(r == null) r = arr.length + 1;
            
            if(arr[i] - l - 1 == m) return i;
            if(r - arr[i] - 1 == m) return i;
        }
        
        return -1;
    }
}