// https://leetcode.com/problems/repeated-dna-sequences/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n <= 10) return new ArrayList<String>();
        HashSet<String> seen = new HashSet(), output = new HashSet();
        
        for (int start = 0; start < n - 9; ++start) {
            String tmp = s.substring(start, start + 10);
            if (seen.contains(tmp)) output.add(tmp);
            else seen.add(tmp);
        }
        return new ArrayList<String>(output);
    }
}