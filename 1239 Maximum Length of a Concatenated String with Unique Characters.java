// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

class Solution {
    int ans;
    public int maxLength(List<String> arr) {
        if(arr.size() == 1) return arr.get(0).length();
        this.ans = 0;
        backtrack(arr, new HashSet<Character>(), 0);
        return this.ans;
    }
    
    private void backtrack(List<String> arr, Set<Character> taken, int s) {
        this.ans = Math.max(this.ans, taken.size());
        
        for(int i = s; i < arr.size(); i++) {
            Set<Character> rem = new HashSet();
            char[] str = arr.get(i).toCharArray();
            boolean track = true;
            for(char c: str) {
                if(!taken.contains(c)) {
                    taken.add(c);
                    rem.add(c);
                }
                else {
                    track = false;
                    break;
                }
            }
            if(track) backtrack(arr, taken, i + 1);
            taken.removeAll(rem);
        }
    }
}