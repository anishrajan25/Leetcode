// https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        boolean[] done = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!done[c - 'a'] && i == s.lastIndexOf(c)) return i;
            else done[c - 'a'] = true;
        }
        
        return -1;
    }
}


// class Solution {
//     public int firstUniqChar(String s) {
//         for(int i=0;i<s.length();i++){
//             int x=s.indexOf(s.charAt(i));
//             if(-1==s.indexOf(s.charAt(i),x+1))
//                 return i;
//         }
//         return -1;
//     }
// }