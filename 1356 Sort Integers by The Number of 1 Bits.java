// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
        return arr;
    }
}

// class Solution {
//     public int[] sortByBits(int[] arr) {
//         Info[] tmp = new Info[arr.length];
//         int i = 0;
//         for(int n: arr) tmp[i++] = new Info(n);
//         Arrays.sort(tmp, (a, b) -> a.bits == b.bits ? a.val - b.val : a.bits - b.bits);
//         i = 0;
//         for(Info info: tmp) arr[i++] = info.val;
//         return arr;
//     }
// }

// class Info {
//     int val, bits;
//     Info(int v) {
//         val = v;
//         bits = Integer.bitCount(v);
//     }
// }