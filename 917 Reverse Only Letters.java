// https://leetcode.com/problems/reverse-only-letters/

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            while (low < high && !Character.isLetter(arr[low])) {
                low++;
            }
            while (low < high && !Character.isLetter(arr[high])) {
                high--;
            }
            if (low < high) {
                char tmp = arr[low];
                arr[low++] = arr[high];
                arr[high--] = tmp;
            }
        }
        return new String(arr);        
    }
}


// class Solution {
//     public String reverseOnlyLetters(String S) {
//         StringBuilder ans = new StringBuilder();
//         int j = S.length() - 1;
//         for (int i = 0; i < S.length(); ++i) {
//             if (Character.isLetter(S.charAt(i))) {
//                 while (!Character.isLetter(S.charAt(j)))
//                     j--;
//                 ans.append(S.charAt(j--));
//             } else {
//                 ans.append(S.charAt(i));
//             }
//         }

//         return ans.toString();
//     }
// }