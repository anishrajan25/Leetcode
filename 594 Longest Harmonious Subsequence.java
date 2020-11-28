// https://leetcode.com/problems/longest-harmonious-subsequence/

class Solution {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i: map.keySet()) if (map.containsKey(i + 1)) res = Math.max(res, map.get(i) + map.get(i + 1));
        return res;
    }
}

// public class Solution {
//     public int findLHS(int[] nums) {
//         HashMap < Integer, Integer > map = new HashMap < > ();
//         int res = 0;
//         for (int num: nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             if (map.containsKey(num + 1))
//                 res = Math.max(res, map.get(num) + map.get(num + 1));
//             if (map.containsKey(num - 1))
//                 res = Math.max(res, map.get(num) + map.get(num - 1));
//         }
//         return res;
//     }
// }