// https://leetcode.com/problems/partition-labels/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for(int i=0; i<n; i++) count[s.charAt(i)-'a'] =i;
        int start = 0;
        while(start < n){
            int end = count[s.charAt(start)-'a'];
            int pos = start;
            while(pos < end){
                end = Math.max(end, count[s.charAt(pos)-'a'] );
                pos++;
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
}