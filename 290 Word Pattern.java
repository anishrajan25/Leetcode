// https://leetcode.com/problems/word-pattern/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap hm = new HashMap<>();
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;
        for(Integer i = 0; i< pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(!hm.containsKey(c))
                hm.put(c, i);
            if(!hm.containsKey(words[i]))
                hm.put(words[i], i);
            if( hm.get(words[i]) != hm.get(c) )
                return false;
        }
        return true;
    }
}