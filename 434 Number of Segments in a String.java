// https://leetcode.com/problems/number-of-segments-in-a-string/

class Solution {
    public int countSegments(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')){
                res++;
            }
        }
        return res;
    }
}

// class Solution {
//     public int countSegments(String s) {
//         String trimmed = s.trim();
//         if (trimmed.equals("")) {
//             return 0;
//         }
//         return trimmed.split("\\s+").length;
//     }
// }