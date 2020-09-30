// https://leetcode.com/problems/subarrays-with-k-different-integers/


class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < A.length; ++right) {
            int x = A[right];
            window1.add(x);
            window2.add(x);

            while (window1.different() > K)
                window1.remove(A[left1++]);
            while (window2.different() >= K)
                window2.remove(A[left2++]);

            ans += left2 - left1;
        }

        return ans;
    }
}

class Window {
    Map<Integer, Integer> count;
    int nonzero;

    Window() {
        count = new HashMap();
        nonzero = 0;
    }

    void add(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonzero++;
    }

    void remove(int x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonzero--;
    }

    int different() {
        return nonzero;
    }
}

// class Solution {
//     public int subarraysWithKDistinct(int[] A, int k) {
//         HashMap<Integer, Integer> count1 = new HashMap();
//         HashMap<Integer, Integer> count2 = new HashMap();
//         int i1 = 0, i2 = 0, j = 0, diff1 = 0, diff2 = 0, res = 0;
        
//         while(j < A.length) {
//             count1.put(A[j], count1.getOrDefault(A[j], 0) + 1);
//             count2.put(A[j], count2.getOrDefault(A[j], 0) + 1);
//             if(count1.get(A[j]) == 1) diff1++;
//             if(count2.get(A[j]) == 1) diff2++;
//             while(diff1 > k) {
//                 count1.put(A[i1], count1.get(A[i1]) - 1);
//                 if(count1.get(A[i1++]) == 0) diff1--;
//             }
//             while(diff2 >= k) {
//                 count2.put(A[i2], count2.get(A[i2]) - 1);
//                 if(count2.get(A[i2++]) == 0) diff2--;
//             }
            
//             res += i2 - i1;
//             j++;
//         }
        
//         return res;
//     }
// }