// https://leetcode.com/problems/count-number-of-teams/


class Solution {
    public int numTeams(int[] arr) {
        int res = 0;
        for(int j  = 0; j < arr.length; j++) {
            int leftLarger = 0, leftSmaller = 0;
            int rightLarger = 0, rightSmaller = 0;
            for(int i = 0; i < j; i++) {
                if(arr[i] > arr[j]) leftLarger++;
                else if(arr[i] < arr[j]) leftSmaller++;
            }
            
            for(int k = j+1; k < arr.length; k++) {
                if(arr[j] > arr[k]) rightSmaller++;
                else if(arr[j] < arr[k]) rightLarger++;
            }
            
            res += (leftLarger*rightSmaller) + (leftSmaller*rightLarger);
        }
        return res;
    }
}

// class Solution {
//     public int numTeams(int[] rating) {
//         int ans = 0;
//         for(int i = 0; i < rating.length - 2; i++) {
//             for(int j = rating.length - 1; j > i + 1; j--) {
//                 int d = rating[i] - rating[j];
//                 if(d == 0 || d == 1 || d == -1) continue;
//                 for(int k = i + 1; k < j; k++) {
//                     if(d > 0 && rating[k] < rating[i] && rating[k] > rating[j]) ++ans;
//                     else if(rating[k] > rating[i] && rating[k] < rating[j]) ++ans;
//                 }
//             }
//         }
        
//         return ans;
//     }
// }