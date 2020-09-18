// https://leetcode.com/problems/find-the-difference/


class Solution {
    public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        for (int i = 0; i < arrS.length; i++) {
            sumS += (int)arrS[i];
            sumT += (int)arrT[i];
        }
        sumT += arrT[arrT.length - 1];
        return (char) (sumT - sumS);
    }
}

///       XOR               //
// class Solution {
    
//     /** Bit Mask */
//     public char findTheDifference(String s, String t) {
//         char diff = t.charAt(t.length() - 1);
        
//         for (int i = 0; i < s.length(); i += 1) {
//             diff ^= s.charAt(i);
//             diff ^= t.charAt(i);
//         }

//         return diff;
//     }
// }


//        COUNT          //
// class Solution {
//     public char findTheDifference(String s, String t) {
//         int[] count = new int[26];
//         for(int i = 0; i<s.length(); ++i) {
//             count[s.charAt(i) - 'a']++;
//             count[t.charAt(i) - 'a']--;
//         }
//         count[t.charAt(s.length()) - 'a']--;
//         for(int i = 0; i<26; ++i)
//             if(count[i] < 0)
//                 return (char)(i + 'a');
        
//         return ' ';
//     }
// }