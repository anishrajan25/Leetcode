// https://leetcode.com/problems/maximum-width-ramp/

class Solution {
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}

class Solution {
    public int maxWidthRamp(int[] A) {
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = A.length - 1; j > i + ans; j--) {
                if(A[i] <= A[j]) {
                    ans = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}