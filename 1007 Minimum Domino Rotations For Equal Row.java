// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int a= countVal(A,B,A[0]);
        int b;
        
        if(a==-1){
            b=countVal(A,B,B[0]);
            return b;
        }         
        b=countVal(A,B,B[0]);
        if(b==-1)
            return a;
        
        return Math.min(a,b);
        
        
    }

    public int countVal(int[] A, int[] B,int val){

        int countA = 0, countB = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] != val && B[i]!=val) return -1;
            else if(A[i]!=val) countA++;
            else if(B[i]!=val) countB++;
        }

        return Math.min(countA, countB);
    }

}

// class Solution {
//     public int minDominoRotations(int[] A, int[] B) {
//         int[] count1=new int[7];
//         int[] count2=new int[7];
//         int[] overlap=new int[7];
//         for(int i=0; i<A.length; i++) {
//             ++count1[A[i]];
//             ++count2[B[i]];
//             if(A[i]==B[i])
//                 ++overlap[A[i]];
//         }
        
//         for(int i=1; i<=6; i++) {
//             if(count1[i]+count2[i]-overlap[i]>=A.length) {
//                 return A.length-Math.max(count1[i], count2[i]);
//             }
//         }
        
//         return -1;
//     }
// }