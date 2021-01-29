// https://leetcode.com/problems/global-and-local-inversions/

class Solution {
    public boolean isIdealPermutation(int[] A) {
        for(int i = 0; i < A.length; i++)
            if(Math.abs(i - A[i]) > 1) return false;
        
        return true;
    }
}

// class Solution {
//     public boolean isIdealPermutation(int[] A) {
//         int[] arr = A.clone();
//         Arrays.sort(arr);
//         for(int i = 0; i < A.length; i++) {
//             if(arr[i] == A[i]) continue;
//             if(i > 0 && arr[i - 1] == A[i]) continue;
//             if(i < A.length - 1 && arr[i + 1] == A[i]) continue;
//             return false;
//         }
        
//         return true;
//     }
// }