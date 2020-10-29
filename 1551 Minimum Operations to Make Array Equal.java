// https://leetcode.com/problems/minimum-operations-to-make-array-equal/

class Solution {
    public int minOperations(int n) {
        if(n==1){
            return 0;
        }
        
        if(n%2==0){
            return n*n/4;
        }else{
            return (n/2+1)*(n/2);
        }
    }
}


// class Solution {
//     public int minOperations(int n) {
//         int last = 2 * n - 1;
//         int mid = (last + 1) / 2;
//         int moves = 0;
        
//         for(int i = 0; i < n/2; i++) moves += mid - 2 * i - 1;
        
//         return moves;
//     }
// }