// https://leetcode.com/problems/buddy-strings/

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(B.length() != A.length()) return false;
        char[] a = A.toCharArray(), b = B.toCharArray();
        boolean res = true;
        int x = helper(a, b, 0);
        if(x == a.length) res = false;
        if(res) {
            int y = helper(a, b, x + 1);
            if(y == a.length) return false;
            int e = helper(a, b, y + 1);
            if(e != a.length) return false;
            return a[x] == b[y] && a[y] == b[x];
        }
        
        int[] c = new int[26];
        for(char ch: a) if(++c[ch - 'a'] > 1) return true;
       
        return false;
    }
    
    private int helper(char[] a, char[] b, int i) {
        while(i < a.length && a[i] == b[i]) i++;
        return i;
    } 
}


// class Solution {
//     public boolean buddyStrings(String A, String B) {
//         if(A.length() != B.length()) return false;
//         if (A.equals(B)) {
//             int[] count = new int[26];
//             for (int i = 0; i < A.length(); ++i)
//                 if(++count[A.charAt(i) - 'a'] > 1) return true;
            
//             return false;
//         }
//         char[] s1 = A.toCharArray(), s2 = B.toCharArray();
//         boolean swap = true;
//         for(int i = 0; i < s1.length; ++i) {
//             if(s1[i] != s2[i]) {
//                 if(!swap) return false;
//                 swap = false;
//                 int j = i++;
//                 while(i < s1.length) {
//                     if(s1[i] == s2[j]) break;
//                     if(s1[i] != s2[i]) return false;
//                     i++;
//                 }
//                 if(i >= s1.length || s1[j] != s2[i]) return false;
//                 char t = s1[i];
//                 s1[i] = s1[j];
//                 s1[j] = t;
//             }
//         }
//         return !swap;
//     }
// }