// https://leetcode.com/problems/three-equal-parts/

class Solution {
    public int[] threeEqualParts(int[] A) {
      int ones = 0;
        int N = A.length;
        for (int i = 0; i < N; i++) 
            ones += A[i];
        
        if (ones == 0) 
            return new int[]{0, N-1};
        
        if (ones % 3 != 0) 
            return new int[]{-1,-1};
        
        int k = ones / 3;
        
        int i;
        for (i = 0; i < N; i++) 
            if (A[i] == 1) break;
        //Found the first 1 of the array.
        int start = i; //[start: ]
        //Find the (k+1)th 1 of the array.
        int count1 = 0;
        for (i = 0; i < N; i++){
            count1 += A[i];
            if (count1 == k+1) break;
        }
        //[mid: ]
        int mid = i;

        //Find (2k + 1)th '1' in the array
        count1 = 0;
        
        for (i = 0; i < A.length; i++){
            count1 += A[i];
            if (count1 == 2*k+1) break;
        }
        
       int end = i; //[end: ]
       //Now we have found the beggning of each interval, let's see if we have a match.
        while (end < N && A[start] == A[mid] && A[mid] == A[end]){
            start++;
            mid++;
            end++;
        }
        
        if (end == N) return new int[]{start - 1, mid};
        
        return new int[]{-1,-1};  
    }
}